package com.example.illabank.utils

import android.text.Editable
import android.text.TextWatcher

class TextChangeWatcher(val onChange: (String) -> Unit) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

    }

    override fun afterTextChanged(editable: Editable?) {
        onChange(editable.toString())
    }
}