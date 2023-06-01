package com.example.common.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

@Suppress("UnnecessaryAbstractClass")
abstract class BaseFragment(@LayoutRes contentLayoutId: Int) : Fragment(contentLayoutId)