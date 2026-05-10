package org.foundrysdk.components

import org.foundrysdk.SecretView
import org.foundrysdk.ViewScope

fun ViewScope.Secret(label: String, key: String) = SecretView(label, key).also { _children += it }
