package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class OrgDeletedEvent(
    val orgId: String,
) : FoundryEvent()
