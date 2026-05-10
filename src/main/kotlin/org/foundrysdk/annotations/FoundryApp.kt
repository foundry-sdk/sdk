package org.foundrysdk.annotations

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class FoundryApp(
    val id:          String,
    val name:        String,
    val description: String,
)
