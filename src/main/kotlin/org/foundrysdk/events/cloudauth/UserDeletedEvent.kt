package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class UserDeletedEvent(
    val userId: String,
    val orgId:  String,
) : FoundryEvent()
