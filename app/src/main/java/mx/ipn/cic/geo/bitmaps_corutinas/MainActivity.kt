package mx.ipn.cic.geo.bitmaps_corutinas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mx.ipn.cic.geo.bitmaps_corutinas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   // Atributo para acceder a los widgets mediante vinculación de vista.
   private lateinit var binding: ActivityMainBinding

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      // Se habilita como comentario el setContentView.
      // setContentView(R.layout.activity_main)
      initBindingView()
      initButtonListener()
   }

   private fun initBindingView() {
      binding = ActivityMainBinding.inflate(layoutInflater)
      val view = binding.root
      setContentView(view)

      // Ocultar el ActionBar.
      this.supportActionBar?.hide()
   }

   private fun initButtonListener() {
      // Recuperar la referencia al widget usando vinculación de vistas.
      binding.btnCorutina.setOnClickListener {
         MainScope().launch {
            binding.mensajeCorutina.text = resources.getText(R.string.mensaje_corutina_inicio)
            delay(2000)
            binding.mensajeCorutina.text = resources.getText(R.string.mensaje_corutina_fin)
         }
      }
   }
}