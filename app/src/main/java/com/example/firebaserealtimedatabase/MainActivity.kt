package com.example.firebaserealtimedatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firebaserealtimedatabase.adapters.UserInfoAdapter
import com.example.firebaserealtimedatabase.models.UserInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.database.*
import com.google.gson.Gson


class MainActivity : AppCompatActivity(),UserInfoAdapter.onItemClickListener {
    lateinit var recyclerView : RecyclerView
    lateinit var databaseRef : DatabaseReference
    lateinit var elementDeleteRef : DatabaseReference
    lateinit var firebaseDatabase : FirebaseDatabase
    var userDataList = ArrayList<UserInfo>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerView)
        firebaseDatabase= FirebaseDatabase.getInstance()
        databaseRef=firebaseDatabase.getReference("UserInfo")
       //elementDeleteRef=firebaseDatabase.getReference("UserInfo").child("8tdmdijouf")

        findViewById<FloatingActionButton>(R.id.addButton).setOnClickListener(){
            val intent= Intent(this@MainActivity,AddPersonalInfo::class.java)
            startActivity(intent)
        }
        readData()

    }
    fun readData(){
        databaseRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                Log.v("value","value "+ snapshot.key)
                //if you want to declare arraylist globally then on every valueEventListener you must clear the list
                userDataList.clear()
               // var userDataList = ArrayList<UserInfo>()
                for (value in snapshot.getChildren()) {
                    val user= value.getValue(UserInfo::class.java)
                    Log.v("value","value "+ Gson().toJson(user))

                    if (user != null) {
                        userDataList.add(user)
                      //  Log.v("value","value "+ Gson().toJson(userDataList))
                    }
                }
                userInfoAdapter(userDataList)

            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "failed to retrieve data", Toast.LENGTH_SHORT).show()

            }

        })
    }
    fun userInfoAdapter(userDataList: ArrayList<UserInfo>) {
        val userInfo:UserInfoAdapter = UserInfoAdapter(userDataList,this@MainActivity)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = userInfo
    }

    override fun onDeleteIconClick(position: Int, userInfo: UserInfo) {
        //databaseRef.child(userInfo.id.toString()).removeValue
        //elementDeleteRef=firebaseDatabase.getReference("UserInfo").child(position.toString())

        databaseRef.child(userInfo.id.toString()).removeValue().addOnCompleteListener {
            Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show()
        }
      /*  databaseRef.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
               // Log.v("deleteuser","delete user"+snapshot.key)


              //  snapshot.child(userInfo.id.toString()).removeValue()



            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })*/
    }

    override fun onItemClick(position: Int, userInfo: UserInfo) {
        val intent = Intent(this,UpdatePersonalInfo::class.java)
       // intent.putExtra("personal_info_object",userDataList.get(position))
        intent.putExtra("personal_info_object", userInfo)
        startActivity(intent)



    }


}