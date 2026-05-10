package org.foundrysdk.components

import org.foundrysdk.BadgeView
import org.foundrysdk.ViewScope

fun ViewScope.Badge(label: String) = BadgeView(label).also { _children += it }
