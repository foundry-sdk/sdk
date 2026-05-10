package org.foundrysdk.components

import org.foundrysdk.TextView
import org.foundrysdk.ViewScope

fun ViewScope.Text(text: String) = TextView(text).also { _children += it }
