package com.example.qpin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.GridView
import android.widget.TextView

class QrmainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_qrmain, container, false)

        val gridView: GridView = view.findViewById(R.id.gridView)
        val adapter = QrmainAdapter(requireContext())
        gridView.adapter = adapter

        val leftTextView: TextView = view.findViewById(R.id.left_text_view)
        val rightTextView: TextView = view.findViewById(R.id.right_text_view)

        leftTextView.text = "QR 안심 카드"
        rightTextView.text = "선택"

        return view
    }
}