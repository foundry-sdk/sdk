package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class PasswordResetEvent(
    val userId: String,
    val orgId:  String,
    val email:  String,
) : FoundryEvent()
