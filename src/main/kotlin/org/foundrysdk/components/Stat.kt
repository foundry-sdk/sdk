package org.foundrysdk.components

import org.foundrysdk.StatView
import org.foundrysdk.ViewScope

fun ViewScope.Stat(label: String, value: String) = StatView(label, value).also { _children += it }
