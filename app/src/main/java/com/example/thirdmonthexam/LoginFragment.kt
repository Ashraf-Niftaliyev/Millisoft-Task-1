package com.example.thirdmonthexam

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.thirdmonthexam.databinding.FragmentLoginBinding
import com.example.thirdmonthexam.model.UserModel
import com.example.thirdmonthexam.roomdb.AppProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.IdontHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
            val provide = AppProvider(requireContext())

            binding.loginButton.setOnClickListener {view ->
                val email = binding.LoginEmailEditText.text.toString()
                val password = binding.LoginPasswordEditText.text.toString()
                CoroutineScope(Dispatchers.Main).launch{
                    provide.getAllUsersEmail(email,password)
                    Navigation.findNavController(view).navigate(R.id.mainFragment)
                }

            }

            fun togglePasswordVisibility(passwordEditText: EditText){
                var selectionStart = passwordEditText.selectionStart
                var selectionEnd = passwordEditText.selectionEnd

                if (passwordEditText.transformationMethod is PasswordTransformationMethod){
                     passwordEditText.transformationMethod = HideReturnsTransformationMethod.getInstance()
                }
                else{
                    passwordEditText.transformationMethod = PasswordTransformationMethod.getInstance()
                }
                  passwordEditText.setSelection(selectionStart,selectionEnd)
            }

            binding.showPasswordHide.setOnClickListener {
                 togglePasswordVisibility(binding.LoginPasswordEditText)

                if (binding.LoginPasswordEditText.transformationMethod is PasswordTransformationMethod){
                      binding.showPasswordHide.setImageResource(R.drawable.visibility_off_icon)
                }
                else{
                    binding.showPasswordHide.setImageResource(R.drawable.visibility_icon)
                }
            }

        }
    }
}