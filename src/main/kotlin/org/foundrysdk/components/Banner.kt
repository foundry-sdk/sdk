package org.foundrysdk.components

import org.foundrysdk.BannerView
import org.foundrysdk.ViewScope

fun ViewScope.Banner(title: String, body: String) = BannerView(title, body).also { _children += it }
