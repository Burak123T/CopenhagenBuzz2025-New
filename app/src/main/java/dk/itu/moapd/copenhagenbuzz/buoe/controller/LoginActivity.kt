package dk.itu.moapd.copenhagenbuzz.buoe.controller

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import dk.itu.moapd.copenhagenbuzz.buoe.databinding.ActivityLoginBinding

/**
 * The login activity of the application. Acts as the main activity, where the user can login
 * as either 1. a guest or 2. a registered user.
 *
 * NOTE: as part of assignment 1, the login activity just goes to the main activity, regardless
 * of which button is pressed!
 */
class LoginActivity : AppCompatActivity() {
    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root) // Set root view of binding the content view

        loginBinding.loginButton.setOnClickListener {
            val goToMainActivityIntent = Intent(this, MainActivity::class.java)
            goToMainActivityIntent.putExtra("isLoggedIn", true)
            startActivity(goToMainActivityIntent)
        }
        loginBinding.guestButton.setOnClickListener {
            val goToMainActivityIntent = Intent(this, MainActivity::class.java)
            goToMainActivityIntent.putExtra("isLoggedIn", false)
            startActivity(goToMainActivityIntent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(loginBinding.main) { v, insets -> // Use binding.main
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}