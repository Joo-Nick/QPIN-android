package com.example.qpin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class QrmainAdapter(private val context: Context) : BaseAdapter() {

    private val images = intArrayOf(
        R.drawable.ic_qrplus,
        R.drawable.ic_qr1,
        R.drawable.ic_qr2,
        R.drawable.ic_qr3,
        R.drawable.ic_qr4,
    )

    private val texts = arrayOf(
        "안심 QR카드 생성",
        "123-456-7890",
        "123-456-7890",
        "123-456-7890",
        "123-456-7890"
    )

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?) : View{
        val view : View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.qrmain_grid_item, parent, false)
        } else {
            view = convertView
        }

        val imageView = view.findViewById<ImageView>(R.id.image_view)
        val textView = view.findViewById<TextView>(R.id.text_view)

        imageView.setImageResource(images[position])
        textView.text = texts[position]

        return view
    }

    override fun getItem(position: Int): Any = images[position]

    override fun getItemId(p0: Int): Long = 0

    override fun getCount(): Int = images.size
}