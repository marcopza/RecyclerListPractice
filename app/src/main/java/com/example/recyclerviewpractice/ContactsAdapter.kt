package com.example.recyclerviewpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter : RecyclerView.Adapter<ContactView>(), ContactView.OnContactDelete{

    private val contacts = ArrayList<Contact>()

    fun addContact(contact: Contact) {
        contacts.add(contact)
        notifyItemInserted(contacts.size - 1)
    }
    // Generar un esqueleto gracias al XML
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactView {

        //Inflater: XML -> View
        var inflater = LayoutInflater.from(parent.context)
        val row = inflater.inflate(R.layout.contactrow, parent, false)
        val contactView = ContactView(row)
        contactView.listener = this
        return contactView

    }

    //Con el esqueleto ya formado, se le ponen los datos correspondientes al esqueleto
    override fun onBindViewHolder(holder: ContactView, position: Int) {
        val contact = contacts[position]
        holder.contact = contact
        holder.nameRow.text = contact.name
        holder.phoneRow.text = contact.phone
    }

    //Este método permite al adaptador saber cuántos elementos se tienen
    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onDelete(contact: Contact) {
        val index = contacts.indexOf(contact)
        contacts.removeAt(index)
        notifyItemRemoved(index)
    }


}