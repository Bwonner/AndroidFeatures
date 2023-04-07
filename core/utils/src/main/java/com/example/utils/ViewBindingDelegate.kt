package com.example.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

fun <T> Fragment.viewBinding(initialise: () -> T): ReadOnlyProperty<Fragment, T> =
    object : ReadOnlyProperty<Fragment, T>, DefaultLifecycleObserver {

        private var binding: T? = null

        // This is called JUST before onDestroyView in a Fragment as a limitation of the lifecycle
        //  library. Do not try to access this property in onDestroyView, as it would
        //  implicitly call the initialise function again and provide a new value.
        override fun onDestroy(owner: LifecycleOwner) {
            binding = null
            this@viewBinding.lifecycle.removeObserver(this)
            super.onDestroy(owner)
        }

        override fun getValue(thisRef: Fragment, property: KProperty<*>): T =
            binding
                ?: initialise().also {
                    binding = it
                    this@viewBinding.viewLifecycleOwner.lifecycle.addObserver(this)
                }
    }
