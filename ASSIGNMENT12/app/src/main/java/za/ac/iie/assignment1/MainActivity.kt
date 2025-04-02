package za.ac.iie.assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val edtTime = findViewById<EditText>(R.id.edtTime)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnSuggestions = findViewById<Button>(R.id.btnSuggestions)
        val btnClear = findViewById<Button>(R.id.btnClear)

            btnSuggestions.setOnClickListener{
                val timeOfDay = edtTime.text.toString().trim()

                var suggestions = ""

                if (timeOfDay == "Morning") {
                    suggestions = "cereal, full english breakfast, cup of coffee"
                } else if (timeOfDay == "mid-morning") {
                    suggestions = "mixed berry smoothie, desired fruit"
                } else if (timeOfDay == "afternoon") {
                    suggestions = "wrap with salad or fries"
                } else if (timeOfDay == "mid-afternoon") {
                    suggestions = "tea with biscuits or cake"
                } else if (timeOfDay == "dinner") {
                    suggestions = "chicken alfredo, pizza, seven colours "
                } else if (timeOfDay == "after dinner snack") {
                    suggestions = "ice cream or Pópcorn"
                } else suggestions = "invalid"

                txtResults.text = suggestions


        }
        btnClear.setOnClickListener{
            edtTime.text.clear()
            txtResults.text=""
        }









            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}