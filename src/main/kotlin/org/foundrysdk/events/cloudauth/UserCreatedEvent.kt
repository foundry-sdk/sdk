package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class UserCreatedEvent(
    val userId: String,
    val email:  String,
    val orgId:  String,
    val plan:   String,
) : FoundryEvent()
