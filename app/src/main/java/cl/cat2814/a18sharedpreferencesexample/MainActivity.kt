package cl.cat2814.a18sharedpreferencesexample

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.cat2814.a18sharedpreferencesexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mSharedPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mSharedPref = getSharedPreferences("Ind17SharPrefExample", Context.MODE_PRIVATE)

        initListeners()
    }

    private fun initListeners() {
        binding.btSave.setOnClickListener {
            val intNumber = binding.etInt.text.toString().toInt()
            val text = binding.etText.text.toString()
            val swBool = binding.swBoolean.isChecked
            val decNumber = binding.etDecimal.text.toString().toFloat()

            saveData(intNumber, text, swBool, decNumber)
        }

        binding.btShow.setOnClickListener {
            showData()
        }

        binding.btDelete.setOnClickListener {
            deleteData()
        }
    }

    private fun deleteData() {

        binding.tvInt.text = ""
        binding.tvText.text = ""
        binding.tvSwitch.text = ""
        binding.tvDecimal.text = ""


        binding.etInt.text.clear()
        binding.etText.text.clear()
        binding.swBoolean.isChecked = false
        binding.etDecimal.text.clear()

        mSharedPref.edit().clear()

    }

    private fun showData() {
        val intNum = mSharedPref.getInt("My int", 0)
        val text = mSharedPref.getString("My text", "")
        val swBool = mSharedPref.getBoolean("My boolean", false)
        val decNum = mSharedPref.getFloat("My float", 0.0f)

        binding.tvInt.text = intNum.toString()
        binding.tvText.text = text
        binding.swBoolean.isChecked = swBool
        binding.tvSwitch.text = swBool.toString()
        binding.tvDecimal.text = decNum.toString()

    }

    private fun saveData(intNum: Int, text: String, swBool: Boolean, decNum: Float) {
        mSharedPref.edit().putInt("My int", intNum).apply()
        mSharedPref.edit().putString("My text", text).apply()
        mSharedPref.edit().putBoolean("My boolean", swBool).apply()
        mSharedPref.edit().putFloat("My float", decNum).apply()

    }
}