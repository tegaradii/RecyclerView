package com.example.pertemuan10

import Mail
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.pertemuan10.R

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mail = intent.getParcelableExtra<Mail>("MAIL_DETAIL")

        findViewById<TextView>(R.id.senderDetail).text = mail?.sender
        findViewById<TextView>(R.id.dateDetail).text = mail?.date
        findViewById<TextView>(R.id.contentDetail).text = mail?.content
    }
}
