package com.example.mysourcebase.ui.auth

import androidx.fragment.app.viewModels
import com.example.mysourcebase.bases.BaseFragment
import com.example.mysourcebase.databinding.FragmentAuthBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthFragment() : BaseFragment<FragmentAuthBinding>(FragmentAuthBinding::inflate) {

    private val authVM: AuthVM by viewModels()

    override fun initData() {

    }

    override fun initView() {

    }

    override fun handleEvent() {
        authVM.signIn()
    }

    override fun bindData() {
        authVM.data.observe(this) {signInResponse ->
            binding.txt.text = signInResponse.toString()
        }
    }

}