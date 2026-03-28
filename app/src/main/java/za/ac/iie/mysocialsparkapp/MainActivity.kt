package za.ac.iie.mysocialsparkapp
import android.util.Log
import android.os.Bundle
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
            Log.d("INPUT", "User entered: $input")

            if (input.isEmpty()) {
                Log.e("ERROR", "Empty input")
                txtResult.text = "⚠️ Please enter a time of day"
                return@setOnClickListener
            }

            val suggestion = when (input) {
                "morning" -> "🌅 Send a 'Good morning' text to a family member"
                "mid-morning" -> "☕ Thank a colleague for something"
                "afternoon" -> "😂 Share a funny meme with a friend"
                "dinner" -> "🍽️ Ask someone how their day was"
                "night" -> "🌙 Send a 'Good night' message"
                else -> "❓ Try: morning, afternoon, night"
            }

            txtResult.text = suggestion
        }

        btnReset.setOnClickListener {
            Log.d("RESET", "User reset the app")
            timeInput.text.clear()
            txtResult.text = "Your suggestion will appear here"
        }
    }
}