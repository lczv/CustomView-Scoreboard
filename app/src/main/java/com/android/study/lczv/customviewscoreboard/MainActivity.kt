package com.android.study.lczv.customviewscoreboard

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnUpdate.setOnClickListener {
            placar.update(edtFirstTeamScore.text.toString().toInt(),
                    edtSecondTeamScore.text.toString().toInt())
        }

    }

}