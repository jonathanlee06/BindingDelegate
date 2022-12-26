package com.jonathanlee.bindingdelegate.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jonathanlee.bindingdelegate.demo.databinding.ActivityMainBinding
import com.jonathanlee.bindingdelegate.demo.second.FragmentActivity
import com.jonathanlee.bindingdelegate.ext.viewBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.button.setOnClickListener {
            val intent = Intent(this, FragmentActivity::class.java).also {
                it.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            }
            startActivity(intent)
        }
    }
}