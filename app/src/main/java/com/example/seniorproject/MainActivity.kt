package com.example.seniorproject

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import java.util.*

class MainActivity : AppCompatActivity() {
    var myListView: ListView? = null
    var mRef: DatabaseReference? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myListView = findViewById<View>(R.id.listview1) as ListView
        val arrayList = ArrayList<String?>()
        //        arrayList.add("test");
        val myArrayAdapter: ArrayAdapter<*> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        myListView!!.adapter = myArrayAdapter
        mRef = FirebaseDatabase.getInstance().reference
        val database = FirebaseDatabase.getInstance()
        //val myRef = database.getReference("message")
        //        myRef.setValue("01: Hello, World!");
        //myRef.getDatabase();
        mRef!!.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val value = snapshot.getValue(String::class.java)
                arrayList.add(value)
                myArrayAdapter.notifyDataSetChanged()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                myArrayAdapter.notifyDataSetChanged()
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}
        })
    }
}