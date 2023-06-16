package com.falcon.gymlog_yaka

import android.util.Log

class BMILogic {
    //Impliment the logic here
    var BMIVal:Float = 0.0f

    fun calBMI(weight:Float, height:Float):Float{
        BMIVal = weight / (height * height)

        Log.e("BMI values is : ", "${BMIVal}")
        return BMIVal
    }


}