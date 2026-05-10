package org.foundrysdk.components

import org.foundrysdk.ButtonView
import org.foundrysdk.ViewScope

fun ViewScope.Button(label: String) = ButtonView(label).also { _children += it }
