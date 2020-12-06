package com.example.seniorproject

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.seniorproject.utils.Constants
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // START
        // Create an instance of Android SharedPreferences
        val sharedPreferences =
            getSharedPreferences(Constants.MYSHOPPAL_PREFERENCES, Context.MODE_PRIVATE)

        val username = sharedPreferences.getString(Constants.LOGGED_IN_USERNAME, "")!!
        // Set the result to the tv_main.
        tv_main.text= "The logged in user is $username."
        // END
    }
}

//class MainActivity : AppCompatActivity() {
//    var myListView: ListView? = null
//    var mRef: DatabaseReference? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        myListView = findViewById<View>(R.id.listview1) as ListView
//        val arrayList = ArrayList<String?>()
//        //        arrayList.add("test");
//        val myArrayAdapter: ArrayAdapter<*> =
//            ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
//        myListView!!.adapter = myArrayAdapter
//        mRef = FirebaseDatabase.getInstance().reference
//        //val database = FirebaseDatabase.getInstance()
//        //val myRef = database.getReference("message")
//        //        myRef.setValue("01: Hello, World!");
//        //myRef.getDatabase();
//        mRef!!.addChildEventListener(object : ChildEventListener {
//            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
//                val value = snapshot.getValue(String::class.java)
//                arrayList.add(value)
//                myArrayAdapter.notifyDataSetChanged()
//            }
//
//            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
//                myArrayAdapter.notifyDataSetChanged()
//            }
//
//            override fun onChildRemoved(snapshot: DataSnapshot) {}
//            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
//            override fun onCancelled(error: DatabaseError) {}
//        })
//    }
//}