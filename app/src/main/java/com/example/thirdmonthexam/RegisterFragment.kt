package com.example.thirdmonthexam

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.thirdmonthexam.databinding.FragmentRegisterBinding
import com.example.thirdmonthexam.model.UserModel
import com.example.thirdmonthexam.roomdb.AppProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.IHaveAnAccount.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
            val provide = AppProvider(requireContext())
            binding.registerButton.setOnClickListener {
                val username = binding.RegisterNameEditText.text.toString()
                val email = binding.RegisterEmailEditText.text.toString()
                val password = binding.RegisterPasswordEditText.text.toString()

                val userModel = UserModel(
                    id = 0,
                    username,
                    email,
                    password
                )
                CoroutineScope(Dispatchers.Main).launch {
                     provide.insertUser(userModel)
                }
            }
        }
    }
}