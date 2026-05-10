package org.foundrysdk

class FoundryContext(
    val org:     OrgContext,
    val secrets: Map<String, String>,
    val store:   Store,
    val event:   Map<String, Any> = emptyMap(),
)

data class OrgContext(
    val id:   String,
    val name: String,
    val plan: String = "free",
)

class Store(private val data: MutableMap<String, String> = mutableMapOf()) {
    private val diff = mutableMapOf<String, String>()

    operator fun get(key: String): String?       = data[key]
    operator fun set(key: String, value: String) { data[key] = value; diff[key] = value }

    fun getOrDefault(key: String, default: String) = data.getOrDefault(key, default)

    fun remove(key: String) { data.remove(key); diff[key] = "" }

    fun pendingWrites(): Map<String, String> = diff.toMap()
}
