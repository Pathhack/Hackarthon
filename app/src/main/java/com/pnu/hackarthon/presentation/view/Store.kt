package com.pnu.hackarthon.presentation.view

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.pnu.hackarthon.R

class Store : Activity() {

    private val detailBtn : Button by lazy { findViewById(R.id.couponImageView) }
    private val detailText : TextView by lazy { findViewById(R.id.couponTextView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_store)

        detailBtn.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.detail_dialog, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle(detailText.text)
            mBuilder.show()
        }

    }
}