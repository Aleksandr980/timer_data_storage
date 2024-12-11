@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.example.m11_timer_data_storage

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import com.example.m11_timer_data_storage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = Repository(this)

        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            repository.saveText(text)
            val textFromRepository = repository.getText()
            binding.textView.setText(textFromRepository)
        }

        binding.button2.setOnClickListener {
            repository.clearText(0).toString()
            binding.textView.text = repository.getText()
            repository.clearText(1).toString()
            binding.editText.setText(repository.getText())
                   }

        binding.editText.setText(repository.getText())
    }
}




