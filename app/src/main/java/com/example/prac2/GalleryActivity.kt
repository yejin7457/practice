package com.example.prac2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.GridView
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {

    private lateinit var gridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val ivBack: ImageView = findViewById(R.id.btnBackMain)
        gridView = findViewById(R.id.gridViewPhotos)

        ivBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        loadImagesFromGallery()
    }

    private fun loadImagesFromGallery() {
        val projection = arrayOf(MediaStore.Images.Media._ID)
        val cursor = contentResolver.query(
            MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
            projection,
            null,
            null,
            null
        )

        cursor?.let {
            val imageIds = mutableListOf<Long>()
            while (cursor.moveToNext()) {
                val id = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID))
                imageIds.add(id)
            }
            cursor.close()

            val adapter = ImageAdapter(this, imageIds)
            gridView.adapter = adapter
        }
    }
}
