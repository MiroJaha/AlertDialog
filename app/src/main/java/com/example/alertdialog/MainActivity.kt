package com.example.alertdialog

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun alertClick(view: View) {
        val dialog= Dialog(this)
        dialog.setContentView(R.layout.message)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val show = dialog.findViewById<Button>(R.id.show)
        val go = dialog.findViewById<Button>(R.id.reDirect)
        val entry= dialog.findViewById<EditText>(R.id.entry)
        val message= dialog.findViewById<TextView>(R.id.message)
        show.setOnClickListener {
            if (entry.text.isNotBlank())
                message.text= entry.text
            else
                Toast.makeText(this,"No Message",Toast.LENGTH_SHORT).show()
        }
        go.setOnClickListener {
            startActivity(Intent(this,Second::class.java))
        }
        dialog.setCancelable(false)
        dialog.show()

    }
}