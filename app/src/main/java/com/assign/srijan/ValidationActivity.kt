package com.assign.srijan

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_validation.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import android.text.Editable

import android.text.TextWatcher
import android.widget.Toast
import java.util.regex.Matcher
import java.util.regex.Pattern


class ValidationActivity : AppCompatActivity() {

    internal companion object {

        operator fun invoke(context: Context) = Intent(context, ValidationActivity::class.java)
    }

    private lateinit var viewModel: ValidationViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_validation)
        viewModel = ViewModelProvider(this).get(ValidationViewmodel::class.java)
        initListeners()
        initObserver()


    }

    private fun initListeners() {
//        editText_name.addTextChangedListener {
//            viewModel.setFirstName(it.toString())
//        }

        editText_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {}
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (!validate(s.toString())) {
                    Toast.makeText(applicationContext, "Enter proper user name", Toast.LENGTH_SHORT)
                        .show()
                }else{
                    submit_button.isEnabled = true
                }
            }
        })


        editText_password.addTextChangedListener {
            viewModel.setPassword(it.toString())
        }
    }

    fun validate(u: String?): Boolean {
        val pattern: Pattern
        val matcher: Matcher
        val PATTERN = "^[A-Za-z0-9]+$"
        pattern = Pattern.compile(PATTERN)
        matcher = pattern.matcher(u)
        return matcher.matches()
    }

    private fun initObserver() {
        lifecycleScope.launch {
            viewModel.isSubmitEnabled.collect { value ->
                submit_button.isEnabled = value
            }
        }
    }
}