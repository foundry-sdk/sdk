package org.foundrysdk

@DslMarker
annotation class FoundryDsl

@FoundryDsl
open class ViewScope {
    @PublishedApi internal val _children = mutableListOf<View>()

    operator fun View.unaryPlus() { _children += this }

    fun Column(block: ViewScope.() -> Unit): ColumnView {
        val scope = ViewScope().apply(block)
        return ColumnView(scope._children.toList()).also { _children += it }
    }

    fun Row(block: ViewScope.() -> Unit): RowView {
        val scope = ViewScope().apply(block)
        return RowView(scope._children.toList()).also { _children += it }
    }
}

fun Column(block: ViewScope.() -> Unit): ColumnView =
    ViewScope().apply(block).let { ColumnView(it._children.toList()) }

fun Row(block: ViewScope.() -> Unit): RowView =
    ViewScope().apply(block).let { RowView(it._children.toList()) }
