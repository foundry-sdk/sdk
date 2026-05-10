package org.foundrysdk

import org.foundrysdk.annotations.*
import org.foundrysdk.errors.ConfigurationException
import org.foundrysdk.components.Banner

abstract class FoundryInstance {
    open fun mainView(ctx: FoundryContext): View =
        throw NotImplementedError(
            "Annotate a method with @MainScreen or override mainView()"
        )

    fun boot(ctx: FoundryContext) {
        validate()
        this::class.java.declaredMethods
            .firstOrNull { it.isAnnotationPresent(OnBoot::class.java) }
            ?.also { it.isAccessible = true }
            ?.invoke(this, ctx)
    }

    fun renderView(name: String, ctx: FoundryContext): View {
        if (name == "main") return resolveMain(ctx)

        val method = this::class.java.declaredMethods.firstOrNull { m ->
            m.isAnnotationPresent(Screen::class.java) &&
            m.getAnnotation(Screen::class.java).name == name
        } ?: return Column {
            +Banner("Not found", "No @Screen(\"$name\") registered in this app.").warning()
        }

        return method.also { it.isAccessible = true }.invoke(this, ctx) as View
    }

    fun handleAction(action: String, ctx: FoundryContext): View {
        val method = this::class.java.declaredMethods.firstOrNull { m ->
            m.isAnnotationPresent(On::class.java) &&
            m.getAnnotation(On::class.java).action == action
        } ?: return resolveMain(ctx)

        return method.also { it.isAccessible = true }.invoke(this, ctx) as View
    }

    fun handleEvent(event: FoundryEvent, ctx: FoundryContext) {
        this::class.java.declaredMethods
            .filter { it.isAnnotationPresent(OnEvent::class.java) }
            .firstOrNull { m ->
                m.parameterTypes.any { it.isAssignableFrom(event::class.java) }
            }
            ?.also { it.isAccessible = true }
            ?.invoke(this, ctx, event)
    }

    private fun validate() {
        val name                 = this::class.simpleName
        val hasMainAnnotation    = this::class.java.declaredMethods
            .any { it.isAnnotationPresent(MainScreen::class.java) }
        val hasMainViewOverride  = this::class.java.declaredMethods
            .any { it.name == "mainView" }

        if (hasMainAnnotation && hasMainViewOverride) throw ConfigurationException(
            "$name defines both @MainScreen and override fun mainView() — pick one"
        )
        if (!hasMainAnnotation && !hasMainViewOverride) throw ConfigurationException(
            "$name has no main screen — annotate a method with @MainScreen or override mainView()"
        )
    }

    private fun resolveMain(ctx: FoundryContext): View {
        val annotated = this::class.java.declaredMethods
            .firstOrNull { it.isAnnotationPresent(MainScreen::class.java) }

        return if (annotated != null) {
            annotated.also { it.isAccessible = true }.invoke(this, ctx) as View
        } else {
            mainView(ctx)
        }
    }
}
