package com.example.navigation

import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavOptions

fun buildDeepLink(destination: DeepLinkDestination) =
    NavDeepLinkRequest.Builder
        .fromUri(destination.address.toUri())
        .build()

fun NavController.deepLinkNavigateTo(
    deepLinkDestination: DeepLinkDestination,
    popUpTo: Boolean = false,
) {
    val builder = NavOptions.Builder()

    if (popUpTo) {
        builder.setPopUpTo(graph.startDestinationRoute, true)
    }

    navigate(
        buildDeepLink(deepLinkDestination),
        builder.build()
    )
}

sealed class DeepLinkDestination(val address: String) {
    class Dashboard(msg: String) : DeepLinkDestination("example://dashboard/exampleArgs?msg=$msg")
    object Next : DeepLinkDestination("example://next")
}

fun Fragment.navigateToFlow(navigationFlow: NavigationFlow) =
    (requireActivity() as ToFlowNavigatable).navigateToFlow(navigationFlow)