package com.example.prac2

import android.graphics.BitmapFactory
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class DrawingMaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawing_mask)

        val photoPath = intent.getStringExtra("photo_path")
        val photoUriString = intent.getStringExtra("photo_uri")
        val imageView: ImageView = findViewById(R.id.imageViewPhoto)

        photoPath?.let {
            val bitmap = BitmapFactory.decodeFile(it)
            imageView.setImageBitmap(bitmap)
        }

        photoUriString?.let {
            val photoUri = Uri.parse(it)
            imageView.setImageURI(photoUri)
        }


        val btnBackGallery = findViewById<ImageView>(R.id.btnBackGallery)
        btnBackGallery.setOnClickListener {
            val intent = Intent(this, GalleryActivity::class.java)
            startActivity(intent)
        }

        // 연필 및 확인 버튼은 현재 기능을 부여하지 않았음
        val ivPencil = findViewById<ImageView>(R.id.ivPencil)
        val ivCheck = findViewById<ImageView>(R.id.ivCheck)

        // 필요한 경우 여기에 기능 추가

        }
    }

