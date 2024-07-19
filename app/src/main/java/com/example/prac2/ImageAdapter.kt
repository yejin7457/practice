package com.example.prac2

import android.content.Context
import android.net.Uri
import android.provider.MediaStore
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

class ImageAdapter(private val context: Context, private val imageIds: List<Long>) : BaseAdapter() {

    override fun getCount(): Int {
        return imageIds.size
    }

    override fun getItem(position: Int): Any {
        return imageIds[position]
    }

    override fun getItemId(position: Int): Long {
        return imageIds[position]
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView = convertView as ImageView? ?: ImageView(context)
        val uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, imageIds[position].toString())
        imageView.setImageURI(uri)
        imageView.layoutParams = ViewGroup.LayoutParams(300, 300) // 원하는 크기로 조절
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return imageView
    }
}