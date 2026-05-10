package org.foundrysdk.events.cloudauth

import org.foundrysdk.FoundryEvent
import kotlinx.serialization.Serializable

@Serializable
data class PlanChangedEvent(
    val orgId:   String,
    val oldPlan: String,
    val newPlan: String,
) : FoundryEvent()
