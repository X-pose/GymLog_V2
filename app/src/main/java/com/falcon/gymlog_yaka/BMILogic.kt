package com.falcon.gymlog_yaka

import android.util.Log

class BMILogic {
    //Impliment the logic here
    var BMIVal:Float = 0.0f
    var maxHealthyWeight: Float = 0.0f
    var minHealthyWeight: Float = 0.0f

    fun calBMI(weight:Float, height:Float):Float{
        BMIVal = weight / (height * height)
        maxHealthyWeight = 24.9f * (height * height)
        minHealthyWeight = 18.5f * (height * height)

        Log.e("BMI values is : ", "${BMIVal}")
        return BMIVal
    }

    fun BMIDescription():String{

        lateinit var description:String

        if(BMIVal > 0 && BMIVal < 18.5){

            description = "Buddy, you're underweight\n Gain atleast ${1 + minHealthyWeight.toInt()}Kg to stay fit"

        }else if(BMIVal >= 18.5 && BMIVal < 24.9){
            description = "Good work Buddy, you're within the normal range!"
        }else if (BMIVal >= 24.9 && BMIVal< 29.9){
            description = "Buddy, you're overweight. It's time to hit the gym\n Keep it under ${1 + maxHealthyWeight.toInt()}Kg"
        }else if(BMIVal >= 30 ){
            description = "Buddy, you're obese. It's time to hit the gym and cut down on your carbs\n Keep it under ${1 + maxHealthyWeight.toInt()}Kg"
        }

        return description
    }


}