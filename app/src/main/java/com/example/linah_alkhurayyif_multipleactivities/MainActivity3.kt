package com.example.linah_alkhurayyif_multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {
    lateinit var infoList:ArrayList<UserInfo>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val name = intent.getStringExtra("Name").toString()
        val location = intent.getStringExtra("Location").toString()
        val phone = intent.getStringExtra("PhoneNumber").toString()
        val password = intent.getStringExtra("Password").toString()

        infoList= arrayListOf()
        infoList.add(UserInfo(name,location,phone,password))


        recyclerView.adapter = InfoRVAdapter(infoList)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         when(item.itemId) {
            R.id.home -> { val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.exit-> {
                finishAffinity()
                return true
            }
        }

        return super.onOptionsItemSelected(item)
    }

}