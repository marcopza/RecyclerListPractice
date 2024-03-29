package com.example.recyclerviewpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)

        contactRecycler.layoutManager = layoutManager
        contactRecycler.setHasFixedSize(true)

        adapter = ContactsAdapter()
        contactRecycler.adapter = adapter

        addBtn.setOnClickListener {
            val contact = Contact(UUID.randomUUID().toString(), nameET.text.toString(), telET.text.toString())
            adapter.addContact(contact)
        }

    }
}