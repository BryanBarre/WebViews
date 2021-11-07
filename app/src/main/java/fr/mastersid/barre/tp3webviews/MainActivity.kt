package fr.mastersid.barre.tp3webviews

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.mastersid.barre.tp3webviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.loadUrl("file:///android_asset/index.html")
        binding.webView.settings.javaScriptEnabled = true

        val toasterJavascriptInterface = ToasterJavascriptInterface ()
        binding.webView.addJavascriptInterface(toasterJavascriptInterface , "Android")

        val squareJavascriptInterface = SquareJavascriptInterface ()
        binding.webView.addJavascriptInterface(squareJavascriptInterface , "Square")

        val divideJavascriptInterface = DivideJavascriptInterface()
        binding.webView.addJavascriptInterface(divideJavascriptInterface,"Divide")

        toasterJavascriptInterface.message.observe(this) { value ->
            if (value.isNotBlank ()) {
                Toast.makeText(this , value , Toast.LENGTH_LONG).show()
            }
        }

        squareJavascriptInterface.c.observe(this){value->
                binding.webView.loadUrl("JavaScript:showSquare($value)")
        }

        divideJavascriptInterface.divide.observe(this){value->
            binding.webView.loadUrl("JavaScript:showDivide($value)")
        }


    }
}