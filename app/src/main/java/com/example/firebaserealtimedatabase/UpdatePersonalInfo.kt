package com.example.firebaserealtimedatabase

import android.os.Build
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.firebaserealtimedatabase.models.UserInfo
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class UpdatePersonalInfo : AppCompatActivity() {
    lateinit var firstName:EditText
    lateinit var fatherName:EditText
    lateinit var phoneNo:EditText
    lateinit var eMail:EditText
    lateinit var btnUpdate:AppCompatButton
    lateinit var firebaseDatabase: FirebaseDatabase
    lateinit var databaseRef: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_personal_info)
        firstName=findViewById(R.id.update_name)
        fatherName=findViewById(R.id.update_fname)
        phoneNo=findViewById(R.id.update_phone)
        eMail=findViewById(R.id.update_email)
        btnUpdate=findViewById(R.id.btn_Update)
        firebaseDatabase= FirebaseDatabase.getInstance()
        databaseRef=firebaseDatabase.getReference("UserInfo")

        // databaseRef=firebaseDatabase.getReference("")






        var userInfoObject: UserInfo?
        if(Build.VERSION.SDK_INT >= 33/*Build.VERSION_CODES.TIRAMISU*/) {
            userInfoObject = intent.extras?.getParcelable("personal_info_object", UserInfo::class.java)
        }
        else {
            userInfoObject = intent.extras?.getParcelable("personal_info_object")

        }
        userInfoObject?.let {
            firstName.setText(it.name)
            fatherName.setText(it.fname)
            phoneNo.setText(it.phoneNo.toString())
            eMail.setText(it.email)


        }
        btnUpdate.setOnClickListener(){

            val userInfoObj= UserInfo(userInfoObject?.id,firstName.text.toString(),fatherName.text.toString(),eMail.text.toString(),
                phoneNo.text.toString().toLong())
            databaseRef.child(userInfoObject!!.id.toString()).setValue(userInfoObj).addOnCompleteListener {
                Toast.makeText(this@UpdatePersonalInfo, "updated succesfully", Toast.LENGTH_SHORT).show()
                finish()
            }

        }






    }
}