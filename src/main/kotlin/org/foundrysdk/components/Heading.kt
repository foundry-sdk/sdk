package org.foundrysdk.components

import org.foundrysdk.HeadingView
import org.foundrysdk.ViewScope

fun ViewScope.Heading(text: String) = HeadingView(text).also { _children += it }
