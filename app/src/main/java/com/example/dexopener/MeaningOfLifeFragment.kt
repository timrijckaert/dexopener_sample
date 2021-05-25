package com.example.dexopener

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

class MeaningOfLifeFragment(private val viewModel: MeaningOfLifeViewModel) : Fragment(R.layout.fragment_meaning_of_life) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val meaningOfLifeTv = view.findViewById<TextView>(R.id.meaningOfLfeTv)
        val meaningOfLifeBtn = view.findViewById<TextView>(R.id.meaningOfLifeBtn)

        viewModel.meaningOfLife.observe(viewLifecycleOwner, meaningOfLifeTv::setText)
        meaningOfLifeBtn.setOnClickListener { viewModel.onUserInteraction() }
    }
}
