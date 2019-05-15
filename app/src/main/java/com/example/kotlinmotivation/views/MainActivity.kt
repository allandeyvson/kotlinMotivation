package com.example.kotlinmotivation.views

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.kotlinmotivation.R
import com.example.kotlinmotivation.mock.Mock
import com.example.kotlinmotivation.util.MotivationConstants
import com.example.kotlinmotivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mFilter: Int = MotivationConstants.PHRASE_FILTER.ALL
    private lateinit var mSecurity: SecurityPreferences
    private val mMock  = Mock()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurity = SecurityPreferences(this)

        setListeners()

        handleFilter(R.id.imgAll)

        refreshPhrase()

        verifyUserName()
    }

    private fun verifyUserName() {
        textUser.text  = mSecurity.getStoreString(MotivationConstants.KEY.PERSON_NAME)
    }

    override fun onClick(view: View) {

        val  id = view.id

        val listId =  listOf(R.id.imgAll, R.id.imgHappy,R.id.imgPublic)
        if (id in listId){
            handleFilter(id)
        } else if (id ==  R.id.btnNewPrhase){
            refreshPhrase()
        }

    }

    private fun refreshPhrase() {

        textPhrase.text = mMock.getPhrase(mFilter)
    }

    private fun handleFilter(id: Int) {

        imgAll.setImageResource(R.drawable.ic_all_unselected)
        imgPublic.setImageResource(R.drawable.ic_public_unselected)
        imgHappy.setImageResource(R.drawable.ic_happy_unselected)


        if (id == R.id.imgAll){
            mFilter =  MotivationConstants.PHRASE_FILTER.ALL
            imgAll.setImageResource(R.drawable.ic_all_selected)
        } else if  (id == R.id.imgHappy){
            mFilter =  MotivationConstants.PHRASE_FILTER.HAPPY
            imgHappy.setImageResource(R.drawable.ic_happy_selected)
        } else {
            mFilter =  MotivationConstants.PHRASE_FILTER.PUBLIC
            imgPublic.setImageResource(R.drawable.ic_public_selected)
        }


    }

    private fun setListeners() {
        imgAll.setOnClickListener(this)
        imgHappy.setOnClickListener(this)
        imgPublic.setOnClickListener(this)

        btnNewPrhase.setOnClickListener(this)
    }
}
