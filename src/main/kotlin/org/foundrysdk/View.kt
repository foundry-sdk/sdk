package org.foundrysdk

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class View

@Serializable @SerialName("Column")
class ColumnView internal constructor(
    val children: List<View> = emptyList(),
) : View()

@Serializable @SerialName("Row")
class RowView internal constructor(
    val children: List<View> = emptyList(),
    val gap:      String     = "md",
    val align:    String     = "center",
) : View()

@Serializable @SerialName("Heading")
class HeadingView internal constructor(val text: String) : View()

@Serializable @SerialName("Text")
class TextView internal constructor(
    val text:    String,
    var variant: String = "body",
) : View() {
    fun muted() = apply { variant = "muted" }
    fun code()  = apply { variant = "code"  }
}

@Serializable @SerialName("Badge")
class BadgeView internal constructor(
    val label:   String,
    var variant: String = "default",
) : View() {
    fun success() = apply { variant = "success" }
    fun warning() = apply { variant = "warning" }
    fun danger()  = apply { variant = "danger"  }
    fun info()    = apply { variant = "info"    }
}

@Serializable @SerialName("Banner")
class BannerView internal constructor(
    val title:   String,
    val body:    String,
    var variant: String = "info",
) : View() {
    fun success() = apply { variant = "success" }
    fun warning() = apply { variant = "warning" }
    fun danger()  = apply { variant = "danger"  }
}

@Serializable @SerialName("Button")
class ButtonView internal constructor(
    val label:   String,
    var action:  String = "",
    var variant: String = "primary",
) : View() {
    fun onClick(action: String) = apply { this.action = action }
    fun secondary()             = apply { variant = "secondary" }
    fun danger()                = apply { variant = "danger"    }
    fun ghost()                 = apply { variant = "ghost"     }
}

@Serializable @SerialName("Link")
class LinkView internal constructor(
    val label: String,
    val url:   String,
) : View()

@Serializable @SerialName("Stat")
class StatView internal constructor(
    val label: String,
    val value: String,
    var trend: String? = null,
) : View() {
    fun trend(t: String?) = apply { trend = t }
}

@Serializable @SerialName("Table")
class TableView internal constructor(
    val columns: List<String>,
    val rows:    List<List<String>>,
) : View()

@Serializable @SerialName("Secret")
class SecretView internal constructor(
    val label:       String,
    val key:         String,
    var placeholder: String? = null,
    var helpText:    String? = null,
) : View() {
    fun placeholder(p: String) = apply { placeholder = p }
    fun help(h: String)        = apply { helpText    = h }
}

@Serializable @SerialName("Divider")
object DividerView : View()

@Serializable @SerialName("Empty")
class EmptyView internal constructor(val message: String = "") : View()
