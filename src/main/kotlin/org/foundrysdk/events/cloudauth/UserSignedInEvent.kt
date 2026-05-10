package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class UserSignedInEvent(
    val userId:    String,
    val orgId:     String,
    val ipAddress: String? = null,
) : FoundryEvent()
