package com.example.linah_alkhurayyif_multipleactivities

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getSupportActionBar()!!.hide()
        signUp.setOnClickListener {
            if (name_et.text.isEmpty() || location_et.text.isEmpty()
                || phonenum_et.text.isEmpty() || password_et.text.isEmpty()){
                   Toast.makeText(this,"Enter your account information",Toast.LENGTH_SHORT).show()
            }else{
                if(checkBox.isChecked){
                    val intent = Intent(this, MainActivity2::class.java)
                    intent.putExtra("Name", name_et.text.toString())
                    intent.putExtra("Location", location_et.text.toString())
                    intent.putExtra("PhoneNumber", phonenum_et.text.toString())
                    intent.putExtra("Password", password_et.text.toString())
                    startActivity(intent)
                }else{
                    alertDialog()
                }
            }
        }
    }
    private fun alertDialog(){
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.agree_alert_dialog, null)
        val ok_btn = view.findViewById<Button>(R.id.ok_btn)
        builder.setView(view)
        val alert = builder.create()
        alert.show()
        ok_btn.setOnClickListener(View.OnClickListener {
            alert.cancel()
        })
    }
}