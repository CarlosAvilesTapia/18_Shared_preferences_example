package cl.cat2814.a18sharedpreferencesexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.cat2814.a18sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initListeners()


    }

    private fun initListeners() {
        binding.btSave.setOnClickListener{
            val intNumber = binding.etInt.text.toString().toInt()
            val text = binding.etText.text.toString()
            val swBool = binding.swBoolean.isChecked.toString().toBoolean()
            val decNumber = binding.etDecimal.text.toString().toDouble()
        }
    }
}