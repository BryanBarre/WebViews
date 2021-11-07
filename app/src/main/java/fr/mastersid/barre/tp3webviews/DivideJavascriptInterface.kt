package fr.mastersid.barre.tp3webviews

import android.util.Log
import android.webkit.JavascriptInterface
import androidx.lifecycle.MutableLiveData

/**
 *Created by Bryan BARRE on 26/10/2021.
 */
class DivideJavascriptInterface  {
    private val _divide = MutableLiveData(0.0)
    val divide: MutableLiveData<Double>
        get() = _divide

    @JavascriptInterface
    fun calculateDivide (message: String) {
        var divide=message.toInt()
        divide *= divide
        var cpt=0
        for (i in 1..divide){
            if (divide%i==0){
                cpt++
            }
        }
        _divide.postValue(cpt.toDouble())

    }
}