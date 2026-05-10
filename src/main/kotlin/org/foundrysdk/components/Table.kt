package org.foundrysdk.components

import org.foundrysdk.TableView
import org.foundrysdk.ViewScope

fun ViewScope.Table(vararg columns: String, rows: List<List<String>>) =
    TableView(columns.toList(), rows).also { _children += it }
