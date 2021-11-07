package fr.mastersid.barre.tp3webviews

import android.webkit.JavascriptInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *Created by Bryan BARRE on 19/10/2021.
 */
class ToasterJavascriptInterface {
    private val _message = MutableLiveData("")
    val message: LiveData<String>
        get() = _message

    @JavascriptInterface
    fun showToast (message: String) {

        _message.postValue("Vous avez entré $message")
    }
}