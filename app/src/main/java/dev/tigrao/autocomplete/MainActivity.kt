package dev.tigrao.autocomplete

import android.os.Bundle
import android.widget.AutoCompleteTextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val dogService by lazy { DogService() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val autoComplete = findViewById<AutoCompleteTextView>(R.id.autoComplete)

        val adapter = AutoCompleteAdapter(dogService.fetchDogs(), baseContext) {
            Toast.makeText(baseContext, "dog was: ${it.name}", Toast.LENGTH_SHORT).show()
        }

        autoComplete.setAdapter(adapter)
    }

}
