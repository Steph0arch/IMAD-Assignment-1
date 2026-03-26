package com.example.socialspark

import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timeInput = findViewById<EditText>(R.id.timeInput)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val txtResult = findViewById<TextView>(R.id.txtResult)

        btnSuggest.setOnClickListener {

            val input = timeInput.text.toString().trim().lowercase()
            Log.d("USER_INPUT", "User entered: $input")

            if (input.isEmpty()) {
                txtResult.text = "Please enter a time of day 😊"
                Log.e("ERROR", "Empty input")
                return@setOnClickListener
            }

            val suggestion = when (input) {

                "morning" -> "Send a Good morning message to a family member ☀️"

                "mid-morning" -> "Thank a colleague for something 👍"

                "afternoon" -> "Share a funny meme with a friend 😂"

                "afternoon snack time" -> "Send a 'thinking of you' message 💬"

                "dinner" -> "Call someone for a quick 5-minute catch-up 📞"

                "night", "after dinner" -> "Leave a thoughtful comment on a post ❤️"

                else -> {
                    Log.w("INVALID_INPUT", "User entered invalid time")
                    "Oops! Try: Morning, Afternoon, Dinner, etc."
                }
            }

            txtResult.text = suggestion
        }

        btnReset.setOnClickListener {
            timeInput.text.clear()
            txtResult.text = "Your suggestion will appear here"
            Log.d("RESET", "User reset the app")
        }
    }
}