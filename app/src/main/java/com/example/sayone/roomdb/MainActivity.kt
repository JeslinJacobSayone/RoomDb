package com.example.sayone.roomdb

import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.util.Log
import android.widget.CompoundButton
import android.widget.RadioGroup
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private val TAG="database values"
    private var qwerty:Boolean ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing the databse MobileDB is the name of the databse
        val Db = Room.databaseBuilder(applicationContext,Appdb::class.java,
                        "MobileDB").build()

        qwerty_sw.setOnCheckedChangeListener(object: CompoundButton.OnCheckedChangeListener{
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

                if (isChecked)
                   qwerty=true
                else
                    qwerty=false
            }

        })


        btn_ok.setOnClickListener{

            // Room db related fuctions cant be done on the main thread
            // threfore creating a seperate thread to run the DB operations
            Thread{
                var mobile = Mobile()
                mobile.type=type_edt.text.toString()
                mobile.manufacturer=manf_edt.text.toString()
                mobile.isQuerty=true

                Db.mobDao().saveNewMobile(mobile)

                Db.mobDao().showAllMobiles().forEach{
                    Log.i(TAG,"id ${it.id}")
                    Log.i(TAG,"type ${it.type}")
                    Log.i(TAG,"manufacturer ${it.manufacturer}")
                    Log.i(TAG,"isQuerty ${it.isQuerty}")
                }

            }.start()

            Toast.makeText(applicationContext,"hai",Toast.LENGTH_LONG).show()
        }






    }
}
