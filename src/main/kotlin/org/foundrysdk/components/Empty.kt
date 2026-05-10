package org.foundrysdk.components

import org.foundrysdk.EmptyView
import org.foundrysdk.ViewScope

fun ViewScope.Empty(message: String = "") = EmptyView(message).also { _children += it }
