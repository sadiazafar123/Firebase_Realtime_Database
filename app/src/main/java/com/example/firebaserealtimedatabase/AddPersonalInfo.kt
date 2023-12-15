package com.example.firebaserealtimedatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import com.example.firebaserealtimedatabase.models.UserInfo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import java.util.*

class AddPersonalInfo : AppCompatActivity() {
    lateinit var nname:EditText
    lateinit var fatherName:EditText
    lateinit var phoneNo:EditText
    lateinit var email:EditText
    lateinit var btnAdd:AppCompatButton
    lateinit var firebaseDatabase:FirebaseDatabase
    lateinit var databaseRef:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_personal_info)
        nname=findViewById(R.id.et_name)
        fatherName=findViewById(R.id.et_fname)
        phoneNo=findViewById(R.id.et_phone)
        email=findViewById(R.id.et_email)
        btnAdd=findViewById(R.id.btn_add)
        firebaseDatabase= FirebaseDatabase.getInstance()
        databaseRef=firebaseDatabase.getReference("UserInfo")

        addUserInfo()


    }
    companion object {
        private val ALLOWED_CHARACTERS = "0123456789qwertyuiopasdfghjklzxcvbnm"
    }
    private fun getRandomString(sizeOfRandomString: Int): String {
        val random = Random()
        val sb = StringBuilder(sizeOfRandomString)
        for (i in 0 until sizeOfRandomString)
            sb.append(ALLOWED_CHARACTERS[random.nextInt(ALLOWED_CHARACTERS.length)])
        return sb.toString()
    }

    fun addUserInfo()
    {
        btnAdd.setOnClickListener(){
           var userName  = nname.text
            var userFatherName = fatherName.text
            var userPhoneNo = phoneNo.text
            var userEmail = email.text
          val id = getRandomString(10)
            val userInfo= UserInfo(id,userName.toString(),userFatherName.toString()
                ,userEmail.toString(),userPhoneNo.toString().toLong())
            databaseRef.child(id).setValue(userInfo).addOnCompleteListener {
                Toast.makeText(this,"user added",Toast.LENGTH_SHORT).show()
                finish()

               // val intent=Intent(this@AddPersonalInfo,MainActivity::class.java)
               // startActivity(intent)

            }


        }


    }
}