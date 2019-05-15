package com.example.kotlinmotivation.views

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.kotlinmotivation.R
import com.example.kotlinmotivation.util.MotivationConstants
import com.example.kotlinmotivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(), View.OnClickListener {

    private  lateinit var mSecurity: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurity = SecurityPreferences(this)

        btnSave.setOnClickListener(this)

        verifyUserName()
    }

    private fun verifyUserName() {
        val userName =  mSecurity.getStoreString(MotivationConstants.KEY.PERSON_NAME)

        if (userName != null){
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        editName.setText(userName)
    }

    override fun onClick(view: View) {
        val id = view.id

        if (id == R.id.btnSave){
            handleSave()
        }
    }

    private fun handleSave() {

        val  name: String = editName.text.toString()
        if (name == ""){
            Toast.makeText(this, "Por favor, informe seu nome.", Toast.LENGTH_LONG).show()
        } else {
            mSecurity.storeString(MotivationConstants.KEY.PERSON_NAME, name)

            val intent: Intent = Intent(this, MainActivity::class.java)

            startActivity(intent)

            finish()
        }
    }
}
