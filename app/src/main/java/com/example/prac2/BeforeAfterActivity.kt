package com.example.prac2

import android.graphics.BitmapFactory
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class BeforeAfterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_before_after)

        val beforePhotoPath = intent.getStringExtra("before_photo_path")
        val afterPhotoPath = intent.getStringExtra("after_photo_path")
        val beforePhotoUriString = intent.getStringExtra("before_photo_uri")
        val afterPhotoUriString = intent.getStringExtra("after_photo_uri")

        val imageViewBefore: ImageView = findViewById(R.id.imageViewPhotoBefore)
        val imageViewAfter: ImageView = findViewById(R.id.imageViewPhotoAfter)

        beforePhotoPath?.let {
            val bitmap = BitmapFactory.decodeFile(it)
            imageViewBefore.setImageBitmap(bitmap)
        }

        beforePhotoUriString?.let {
            val photoUri = Uri.parse(it)
            imageViewBefore.setImageURI(photoUri)
        }

        afterPhotoPath?.let {
            val bitmap = BitmapFactory.decodeFile(it)
            imageViewAfter.setImageBitmap(bitmap)
        }

        afterPhotoUriString?.let {
            val photoUri = Uri.parse(it)
            imageViewAfter.setImageURI(photoUri)
        }

        val btnBackDrawingMask = findViewById<ImageView>(R.id.btnBackDrawingMask)
        btnBackDrawingMask.setOnClickListener {
            val intent = Intent(this, DrawingMaskActivity::class.java)
            startActivity(intent)
        }

        // 확인 버튼은 현재 기능을 부여하지 않았음
        val ivCheck = findViewById<ImageView>(R.id.ivCheck)

        // 필요한 경우 여기에 기능 추가
    }
}
