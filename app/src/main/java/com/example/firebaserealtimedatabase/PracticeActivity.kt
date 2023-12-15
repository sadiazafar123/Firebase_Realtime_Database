package com.example.firebaserealtimedatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.firebaserealtimedatabase.models.UserInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import java.util.*

class PracticeActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    lateinit var nname: EditText
    lateinit var fName: EditText
    lateinit var email: EditText
    lateinit var phoneNo: EditText
    lateinit var btnAdd: AppCompatButton
    lateinit var firebaseDatabse: FirebaseDatabase
    lateinit var databaseRef: DatabaseReference
    /*   lateinit var firebaseUser : FirebaseUser
       lateinit var firebaseAuth : FirebaseAuth*/
    lateinit var userInfo: UserInfo


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice)
       // nname = findViewById(R.id.et_name)
       // fName = findViewById(R.id.et_fname)
       // email = findViewById(R.id.et_email)
      //  phoneNo = findViewById(R.id.et_phone)
      //  btnAdd = findViewById(R.id.btn_add)
        firebaseDatabse = FirebaseDatabase.getInstance()
        databaseRef = firebaseDatabse.getReference("UserInfo")
        //addUserInfo()
       // readData()
        //  databaseRef.setValue(userInfo)

    }
/*
    fun readData(){
*/


/*
        databaseRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                // val value= snapshot.getValue(String::class.java)
                //val value = snapshot.children()
                for (data in snapshot.getChildren()) {
                    val firebasemodel: UserInfo? = data.getValue(UserInfo::class.java)
                    firebasemodel.add(UserInfo)
                }

                Log.v("userInfo","$value")


            }

            override fun onCancelled(error: DatabaseError) {
                Log.v("userInfo","$error")


            }
        })
*/
    }


/*
    companion object {
        private val ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm"
    }
*/



/*
    private fun getRandomString(sizeOfRandomString: Int): String {
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString)
            sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }
*/
/*
    fun   addUserInfo(){
        btnAdd.setOnClickListener(){

            var name = nname.text.toString()
            var fatherName = fName.text
            var userEmail = email.text
            var userPhoneNo = phoneNo.text
            val id = getRandomString(10)
            userInfo = UserInfo(id, name, fatherName.toString(), userPhoneNo.toString().toLong())
            databaseRef.child(id).setValue(userInfo).addOnCompleteListener {
                Toast.makeText(this, "User added", Toast.LENGTH_SHORT).show()
                nname.setText("")
                fName.setText("")
                email.setText("")
                phoneNo.setText("")
            }
        } }
*/























    // val database= Firebase.database
    // val name: String = employeeNameEdt.getText().toString()

    //write to your database
    // val myRef= database.getReference("message")
    // val myRef = database.getReference("model")
    //  var userInfo :UserInfo= UserInfo()

    // myRef.setValue(UserInfo)
    //read from your database
/*
        myRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value =snapshot.getValue<String>()
                Log.v("databasevalue","database value"+value)

            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.v("databasevalue", error.toException().toString())

            }

        })
*/










