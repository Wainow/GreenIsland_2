package com.wainow.greenisland.presentation.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

/**
 * Extension function for `Flow` that collects the flow in a lifecycle-aware manner and performs a given action
 * on each emitted value.
 *
 * This function ensures that the flow is collected only when the provided `Lifecycle` is in an active state,
 * and it executes the specified `action` each time a new value is emitted. The collection is automatically
 * stopped when the lifecycle becomes inactive, preventing memory leaks and unnecessary work.
 *
 * @param lifecycle The `Lifecycle` to which the flow collection should be bound. The flow will be collected
 *                  only when this lifecycle is in an active state (e.g., STARTED or RESUMED).
 * @param action The suspend function to be executed on each emitted value from the flow.
 *
 * @receiver The `Flow` instance on which this extension function is called.
 */
fun <T> Flow<T>.executeWithLifecycle(
    lifecycle: Lifecycle,
    action: suspend (T) -> Unit,
) = flowWithLifecycle(lifecycle)
    .onEach(action)
    .launchIn(lifecycle.coroutineScope)