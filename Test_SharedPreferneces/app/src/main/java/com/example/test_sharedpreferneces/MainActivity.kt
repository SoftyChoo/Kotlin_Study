package com.example.test_sharedpreferneces

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test_sharedpreferneces.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    companion object {
        val PREFERENCES_FILE_NAME: String = "pref_file_name"
        val PREFERENCES_KEY : String = "key_name"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                saveData()
                Toast.makeText(this@MainActivity,"Data Saved.",Toast.LENGTH_SHORT).show()
            }
        }
        loadData()
    }

    private fun loadData() {
        val pref = getSharedPreferences(PREFERENCES_FILE_NAME,0)
        binding.etHello.setText(pref.getString(PREFERENCES_KEY,""))
    }

    private fun saveData() {
        val pref = getSharedPreferences(PREFERENCES_FILE_NAME, 0)
        val edit = pref.edit() // 수정모드
        // 첫번째 인자 -> Key
        // 두번째 인자 -> 넣어줄 값
        edit.putString(PREFERENCES_KEY,binding.etHello.text.toString())
        edit.apply()
    }


}