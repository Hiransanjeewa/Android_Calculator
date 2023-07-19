package com.sanjeewabasnayaka.android.androidcalculator.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import com.sanjeewabasnayaka.android.androidcalculator.R


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }// Main fragment , Main fragment only interact with on ViewModel for one view

    private lateinit var viewModel: MainViewModel   // making the direct connection to ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        // TODO: Use the ViewModel
    }

    //@SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view= inflater.inflate(R.layout.fragment_main, container, false)

//
//        var message=view.findViewById<TextView>(R.id.message)
//
//
//
//        viewModel.result.observe(viewLifecycleOwner, Observer {
//            message.text=it.toString()
//        })// Listing to the changes of result
//        var addButton = view.findViewById<Button>(R.id.addButton)
//
//        addButton.setOnClickListener {
//            viewModel.addition(Math.random()*12,6.0)
//
//        }

        val number1= view?.findViewById<EditText>(R.id.textBox1)
        val number2=view?.findViewById<EditText>(R.id.textBox2)

        val message = view.findViewById<TextView>(R.id.message)

        // message.text=viewModel.result.value.toString()
        viewModel.result.observe(viewLifecycleOwner, Observer {
            message.text=it.toString() // listening to result value changes
        })

        fun checkInputs(): Boolean {
            if (number1!=null && number2!=null){
                return false;
            }
                return true;

        }

        val addButton = view.findViewById<Button>(R.id.addButton)
        addButton.setOnClickListener {
            if (number1!=null && number2!=null){
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.addition(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                } else {
                    message.text = "Please Enter "
                }
            }
        }

        var subsButton = view.findViewById<Button>(R.id.substractButton)
        subsButton.setOnClickListener {
            if (number1!=null && number2!=null){
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.subtraction(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }
        var prodButton = view.findViewById<Button>(R.id.multiplyButton)
        prodButton.setOnClickListener {
            if (number1!=null && number2!=null) {
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.multiplication(
                        number1.text.toString().toDouble(),
                        number2.text.toString().toDouble()
                    )
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }
        var divButton = view.findViewById<Button>(R.id.divButton)
        divButton.setOnClickListener {
            if (number1!=null && number2!=null){
                if (number1.text.isNotBlank() && number2.text.isNotBlank()) {
                    viewModel.division(number1.text.toString().toDouble(), number2.text.toString().toDouble())
                } else {
                    message.text = "Fill both inputs"
                }
            }
        }
        val clearButton = view.findViewById<Button>(R.id.clearButton)
        clearButton.setOnClickListener {
            // Set the values to 0
            number1?.setText("")
            number2?.setText("")
            message?.text = "0.0"
            number1?.hint = resources.getString(R.string.enter_first_number)
            number2?.hint = resources.getString(R.string.enter_second_number)
        }





        return view
    }

}