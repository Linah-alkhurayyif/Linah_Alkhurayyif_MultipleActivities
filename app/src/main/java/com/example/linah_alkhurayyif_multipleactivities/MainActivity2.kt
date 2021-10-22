package com.example.linah_alkhurayyif_multipleactivities

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    lateinit var name:String
    lateinit var location:String
    lateinit var phone:String
    lateinit var password:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        getSupportActionBar()!!.hide()
         name = intent.getStringExtra("Name").toString()
         location = intent.getStringExtra("Location").toString()
         phone = intent.getStringExtra("PhoneNumber").toString()
         password = intent.getStringExtra("Password").toString()
        nametv.text = name
        locationtv.text = location
        phoneNumbertv.text = phone
        Passwordtv.text = password
        confirm.setOnClickListener {  confirmAlertDialog() }
    }

    private fun confirmAlertDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.alert_dialog, null)
        builder.setView(view)
        val confirm = view.findViewById<Button>(R.id.confirm_btn)
        val name_tv = view.findViewById<TextView>(R.id.name_tv)
        val location_tv= view.findViewById<TextView>(R.id.location_tv)
        val phone_tv = view.findViewById<TextView>(R.id.phone_tv)
        val password_tv = view.findViewById<TextView>(R.id.password_tv)
        val show_pw = view.findViewById<ImageView>(R.id.show_pw)
        val hidden_pw = view.findViewById<ImageView>(R.id.hidden_pw)

        var star = ""

        for(i in password){
            star+="*"
        }
        name_tv.text = "name: "+name
        location_tv.text = "location: "+ location
        phone_tv.text = "phone number: "+phone
        password_tv.text = "password: "+ star
        val alert = builder.create()
        alert.show()
        show_pw.setOnClickListener(View.OnClickListener {
                password_tv.text = "password: "+ password
                hidden_pw.isVisible=true
                show_pw.isVisible=false
        })
        hidden_pw.setOnClickListener(View.OnClickListener {
            password_tv.text = "password: "+ star
            hidden_pw.isVisible=false
            show_pw.isVisible=true
        })

        confirm.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            intent.putExtra("Name", name)
            intent.putExtra("Location", location)
            intent.putExtra("PhoneNumber", phone)
            intent.putExtra("Password", password)
            startActivity(intent)
            alert.cancel()
        })
    }
}