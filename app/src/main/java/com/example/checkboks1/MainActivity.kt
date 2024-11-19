package com.example.checkboks1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)

        saveButton.setOnClickListener {
            val inputText = editText.text.toString()
            textView.text = inputText
        }

        deleteButton.setOnClickListener {
            Button_delete()
        }
    }

    private fun Button_delete() {
        val delete_input = AlertDialog.Builder(this)
        delete_input.setTitle("Подтвердите удаление")
        delete_input.setPositiveButton("Удалить") { a, b ->
            textView.text = ""
            Snackbar.make(findViewById(android.R.id.content), "Данные удалены", Snackbar.LENGTH_SHORT).show()
        }
        delete_input.setNegativeButton("Отмена") { a, b -> a.dismiss() }
        delete_input.show()
    }
}