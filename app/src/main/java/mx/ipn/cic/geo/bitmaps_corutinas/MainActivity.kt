package mx.ipn.cic.geo.bitmaps_corutinas

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mx.ipn.cic.geo.bitmaps_corutinas.databinding.ActivityMainBinding
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
   // Atributo para acceder a los widgets mediante vinculación de vista.
   private lateinit var binding: ActivityMainBinding
   private lateinit var  imageViewShow: ImageView

   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      // Se habilita como comentario el setContentView.
      // setContentView(R.layout.activity_main)
      initBindingView()
      initButtonListener()
      imageViewShow = findViewById(R.id.imagen)
   }

   private fun cargarBitmap(){
      val aleatorio = (0..9).random()
      val resourceId = resources.getIdentifier(
         "imagen${aleatorio.toString()}", "drawable", packageName)
      val task = BitmapEjercicio(imageViewShow)
      task.execute(resourceId)
      //return true
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
            Toast.makeText(applicationContext, "Cargando Imagen...", Toast.LENGTH_SHORT).show()
               cargarBitmap()

         }
      }
   }
}