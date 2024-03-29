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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BMIFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

//New ideas - show whether your BMI is ok or not.
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b_m_i, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var edtHeight: Float
        var edtWeight: Float
        var setResult: Float
        var bmiDescription: String

        val calBMI = BMILogic()


        val btnResult = view?.findViewById<Button>(R.id.btnCalBMI)
        btnResult?.setOnClickListener() {
            edtHeight = view?.findViewById<EditText>(R.id.edtHeight)?.text.toString().toFloat()
            edtWeight = view?.findViewById<EditText>(R.id.edtWeight)?.text.toString().toFloat()

            setResult = calBMI.calBMI(edtWeight, edtHeight)
            bmiDescription = calBMI.BMIDescription()

            var resultVal = view?.findViewById<TextView>(R.id.BMIdescription)

            Log.e("Result is : ", "${setResult}")
            val trimmedResult = String.format("%.1f", setResult)
            resultVal?.text = ("Your BMI : " + trimmedResult + "\n\n"+ bmiDescription +"\n\n" )

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