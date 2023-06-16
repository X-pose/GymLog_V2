package com.falcon.gymlog_yaka

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.Console

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BMIFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BMIFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnResult = view.findViewById<Button>(R.id.btnCalBMI)

        var edtHeight: Float
        var edtWeight: Float
        var setResult: Float

        var calBMI = BMILogic()

        btnResult?.setOnClickListener() {
            edtHeight = view.findViewById<EditText>(R.id.edtHeight)?.text.toString().toFloat()
            edtWeight = view.findViewById<EditText>(R.id.edtWeight)?.text.toString().toFloat()

            setResult = calBMI.calBMI(edtWeight, edtHeight)

            var resultVal = view.findViewById<TextView>(R.id.ansBMI)
            Log.e("Result is : ", "${setResult}")
            resultVal?.text = ("Your BMI : " + setResult.toString())
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BMIFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BMIFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}