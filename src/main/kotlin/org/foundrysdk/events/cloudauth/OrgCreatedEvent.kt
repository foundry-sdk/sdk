package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class OrgCreatedEvent(
    val orgId: String,
    val name:  String,
    val plan:  String,
) : FoundryEvent()
