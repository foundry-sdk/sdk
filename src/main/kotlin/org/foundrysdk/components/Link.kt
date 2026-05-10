package org.foundrysdk.components

import org.foundrysdk.LinkView
import org.foundrysdk.ViewScope

fun ViewScope.Link(label: String, url: String) = LinkView(label, url).also { _children += it }
