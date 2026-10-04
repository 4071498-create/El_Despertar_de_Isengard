package com.isengard.fruegas

import android.os.Bundle
import android.util.Log
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val TAG = "Ciclo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnEnviar = findViewById<ImageButton>(R.id.enviar)
        val cbAntorcha = findViewById<CheckBox>(R.id.antorcha)
        var antorcha = false
        val etNombre = findViewById<EditText>(R.id.identif)

        etNombre.requestFocus()

        etNombre.setOnFocusChangeListener { view, hasFocus->
            if(!hasFocus){
                if(etNombre.text.isEmpty()) etNombre.error = "El ejército no acepta soldados anónimos"
            }

        }

        cbAntorcha.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                antorcha = true
            }else{
                antorcha = false
            }
        }

        btnEnviar.setOnClickListener {
            if(!etNombre.text.isEmpty()){
                Toast.makeText(this, "¡Unidad ${etNombre.text} enviada al Abismo de Helm!", Toast.LENGTH_LONG).show()
            }
            if(antorcha == false){
                Log.e(TAG, "¡Peligro! Unidad enviada sin fuego!")
            }


        }


        //Implementa los métodos del ciclo de vida: onCreate(), onStart(), onResume(), onPause(), onStop() y onDestroy().
        Log.d(TAG, "onCreate: Los cimientos de Isengard se establecen")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Las fraguas se encienden")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: La maquinaria opera a pleno rendimiento a la vista de todos")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Saruman detiene la producción temporalmente")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Las fraguas se ocultan en las sombras")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: La maquinaria ha sido destruida y el imperio de Isengard ha caído")
    }
}