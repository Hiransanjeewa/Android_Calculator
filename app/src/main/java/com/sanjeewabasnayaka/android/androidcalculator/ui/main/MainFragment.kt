package com.sanjeewabasnayaka.android.androidcalculator.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.sanjeewabasnayaka.android.androidcalculator.R
import org.w3c.dom.Text

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view= inflater.inflate(R.layout.fragment_main, container, false)

        var message=view?.findViewById<TextView>(R.id.message)
        if (message!=null){
            message.text= "Hiran"
        }
        return view
    }

}