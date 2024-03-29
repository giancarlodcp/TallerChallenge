package com.gian.login

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isGone
import androidx.core.view.isVisible
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity(), CoroutineScope {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username:EditText = findViewById(R.id.txtUsername)
        val password:EditText = findViewById(R.id.txtPassword)
        val button:Button = findViewById(R.id.button)
        val progressBar: ConstraintLayout = findViewById(R.id.progress)


        button.setOnClickListener {
            launch{
                progressBar.isVisible = true
                simulateCoroutineSleep()
                progressBar.isGone = true
                if(username.text.toString() == "admin" && password.text.toString()=="123456"){
                    //Success
                    button.text = "Success"

                } else {
                    //Failure
                    button.text = "Failure"

                }
            }

        }

    }

    private suspend fun simulateCoroutineSleep() {
        //Thread.sleep(6000)
        delay(6000)
    }

    override val coroutineContext: CoroutineContext
        get() = Job() + Dispatchers.Main
}