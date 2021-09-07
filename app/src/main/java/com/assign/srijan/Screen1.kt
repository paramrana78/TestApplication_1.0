/*
 * *
 *  * Created by Paramjit.Rana on 03/09/21, 2:54 PM
 *  * Copyright (c) 2021 . All rights reserved.
 *  * Last modified 03/09/21, 2:49 PM
 *
 */

package com.assign.srijan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.text.Editable

import android.text.TextWatcher
import android.view.View
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow


class Screen1 : AppCompatActivity() {
    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonConfirm: Button? = null
    private lateinit var viewModel: ValidationViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sc_1)

        supportActionBar?.setTitle("Assignment")
        editTextUsername = findViewById(R.id.edit_text_username);
        editTextPassword = findViewById(R.id.edit_text_password);
        buttonConfirm = findViewById(R.id.button_confirm);

        editTextUsername?.addTextChangedListener(loginTextWatcher);
        editTextPassword?.addTextChangedListener(loginTextWatcher);





        buttonConfirm?.setOnClickListener {
            Intent(this, Screen2::class.java).apply {
                startActivity(this)
            }
        }
    }


    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = editTextUsername!!.text.toString().trim { it <= ' ' }
            val passwordInput = editTextPassword!!.text.toString().trim { it <= ' ' }

            buttonConfirm!!.isEnabled = usernameInput.isNotEmpty()&& usernameInput.length>=5 && passwordInput.isNotEmpty()&& passwordInput.length>=5






        }

        override fun afterTextChanged(s: Editable) {}
    }



    //can also be used to perform intent action on button click
    // but i wouldn't prefer this for minor task
    @ExperimentalCoroutinesApi
    fun View.clicks(): Flow<Unit> = callbackFlow {
        setOnClickListener {
            offer(Unit)
        }
        awaitClose { setOnClickListener(null) }
    }
}