package fr.mastersid.barre.tp3webviews

import android.util.Log
import android.webkit.JavascriptInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *Created by Bryan BARRE on 26/10/2021.
 */
class SquareJavascriptInterface {
    private val _c = MutableLiveData(0.0)
    val c: MutableLiveData<Double>
        get() = _c

    @JavascriptInterface
    fun calculateSquare (message: String) {
        var c=message.toDouble()
        c *= c
        _c.postValue(c)
    }
}