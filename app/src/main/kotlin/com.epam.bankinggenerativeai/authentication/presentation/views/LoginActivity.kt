package com.epam.bankinggenerativeai.authentication.presentation.views

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.epam.bankinggenerativeai.R
import com.epam.bankinggenerativeai.authentication.presentation.viewmodels.LoginState
import com.epam.bankinggenerativeai.authentication.presentation.viewmodels.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private val viewModel: LoginViewModel by viewModels()

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button // Add the Register button variable
    private lateinit var loadingProgressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initViews()
        observeLoginResult()
    }

    private fun initViews() {
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton) // Initialize the Register button
        loadingProgressBar = findViewById(R.id.loadingProgressBar)

        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            viewModel.login(email, password)
        }

        // Set an OnClickListener for the Register button
        registerButton.setOnClickListener {
            // Handle the registration process here
            Toast.makeText(this, "Register button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun observeLoginResult() {
        lifecycleScope.launch {
            viewModel.loginResult.collect { state ->
                when (state) {
                    is LoginState.Initial -> {
                        // Handle the initial state if needed
                    }

                    is LoginState.Loading -> {
                        loadingProgressBar.visibility = View.VISIBLE
                    }

                    is LoginState.Success -> {
                        loadingProgressBar.visibility = View.GONE
                        showSuccessDialog()
                    }

                    is LoginState.Error -> {
                        loadingProgressBar.visibility = View.GONE
                        // Show error message
                        Toast.makeText(this@LoginActivity, state.message, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    private fun showSuccessDialog() {
        AlertDialog.Builder(this)
            .setTitle("Login Successful")
            .setMessage("You have successfully logged in.")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
                // Navigate to the main activity or perform other actions after dismissing the dialog
            }
            .show()
    }
}