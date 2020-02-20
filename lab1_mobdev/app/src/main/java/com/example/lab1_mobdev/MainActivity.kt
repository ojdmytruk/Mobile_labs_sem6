package com.example.lab1_mobdev

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var rgroup_india : RadioGroup
    lateinit var rbutton_polo : RadioButton
    lateinit var rbutton_vespucci : RadioButton
    lateinit var rbutton_kuk : RadioButton
    lateinit var rbutton_gama : RadioButton

    lateinit var cbox_pressure : CheckBox
    lateinit var cbox_hight : CheckBox
    lateinit var cbox_lattitude : CheckBox
    lateinit var cbox_angle : CheckBox

    lateinit var button_ok : Button
    lateinit var tv_answer : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rgroup_india = findViewById(R.id.rgroup_india) as RadioGroup
        rbutton_polo = findViewById(R.id.rbutton_polo) as RadioButton
        rbutton_vespucci = findViewById(R.id.rbutton_vespucci) as RadioButton
        rbutton_kuk = findViewById(R.id.rbutton_kuk) as RadioButton
        rbutton_gama = findViewById(R.id.rbutton_gama) as RadioButton

        cbox_pressure = findViewById(R.id.cbox_pressure) as CheckBox
        cbox_hight = findViewById(R.id.cbox_hight) as CheckBox
        cbox_lattitude = findViewById(R.id.cbox_lattitude) as CheckBox
        cbox_angle = findViewById(R.id.cbox_angle) as CheckBox

        button_ok = findViewById(R.id.button_ok) as Button
        tv_answer = findViewById(R.id.tv_answer) as TextView


        button_ok.setOnClickListener(View.OnClickListener {

            var result = ""
            if (rgroup_india.checkedRadioButtonId != -1){
                result += "Експедиція: "

                if (rbutton_polo.isChecked)
                    result += "${rbutton_polo.text}\n"
                else if (rbutton_vespucci.isChecked)
                    result +="${rbutton_vespucci.text}\n"
                else if (rbutton_kuk.isChecked)
                    result += "${rbutton_kuk.text}\n"
                else if (rbutton_gama.isChecked)
                    result += "${rbutton_gama.text}\n"
            }
            else result += "Експедиція: не обрано \n"
            result += "Температура: "
            if ((cbox_angle.isChecked == false) and (cbox_lattitude.isChecked == false)
                and (cbox_hight.isChecked == false) and (cbox_pressure.isChecked == false))
                result += "не обрано\n"
            if (cbox_pressure.isChecked)
                result += "${cbox_pressure.text}.\n"
            if (cbox_hight.isChecked)
                result +="${cbox_hight.text}.\n"
            if (cbox_lattitude.isChecked)
                result += "${cbox_lattitude.text}.\n"
            if (cbox_angle.isChecked)
                result += "${cbox_angle.text}.\n"

            tv_answer.text =result
        })

    }
}
