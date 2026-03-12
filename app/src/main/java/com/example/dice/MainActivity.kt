package com.example.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imageDice: ImageView = findViewById(R.id.image_dice)
        val imageDice2: ImageView = findViewById(R.id.image_dice2)

        val btn: Button = findViewById(R.id.roll_btn)

        btn.setOnClickListener {
            randomwen(imageDice)
            randomwen(imageDice2)
            animation(imageDice)
            animation(imageDice2)
        }

    }
 }




fun randomwen(image: ImageView) {
    var randomNum = (1..6).random()

    val pic = when (randomNum) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
  image.setImageResource(pic)
}


fun animation(image: ImageView){

    image.rotation = 0f
    image.scaleX = 1f
    image.scaleY = 1f


    image.animate()
        .rotationBy(720f)
        .scaleX(1.3f)
        .scaleY(1.3f)
        .setDuration(300)
        .withEndAction {
            image.animate()
                .scaleX(1f)
                .scaleY(1f)
                .setDuration(200)
        }

}
