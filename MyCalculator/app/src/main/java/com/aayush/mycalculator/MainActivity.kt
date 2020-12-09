package com.aayush.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception


class MainActivity : AppCompatActivity() {

   private lateinit var  Text : TextView
    private lateinit var  TextResult : TextView
    private lateinit var btn1 : Button
    private lateinit var btn2 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    private lateinit var btn5 : Button
    private lateinit var btn6 : Button
    private lateinit var btn7 : Button
    private lateinit var btn8 : Button
    private lateinit var btn9 : Button
    private lateinit var btn0 : Button
    private lateinit var btnPlus : Button
    private lateinit var btnMinus : Button
    private lateinit var btnMultiply : Button
    private lateinit var btnDivide : Button
    private lateinit var btnEqual : Button
    private lateinit var btnDot : Button
    private lateinit var btnClear : Button
    private lateinit var btnBack : Button




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Text = findViewById(R.id.Text)
        TextResult = findViewById(R.id.TextResult)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnPlus = findViewById(R.id.btnPlus)
        btnMinus = findViewById(R.id.btnMinus)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnDivide = findViewById(R.id.btnDivide)
        btnEqual = findViewById(R.id.btnEqual)
        btnDot = findViewById(R.id.btnDot)
        btnClear = findViewById(R.id.btnClear)
        btnBack = findViewById(R.id.btnBack)


//number
        btn1.setOnClickListener{appendOnExpression("1", true)}
        btn2.setOnClickListener{appendOnExpression("2", true)}
        btn3.setOnClickListener{appendOnExpression("3", true)}
        btn4.setOnClickListener{appendOnExpression("4", true)}
        btn5.setOnClickListener{appendOnExpression("5", true)}
        btn6.setOnClickListener{appendOnExpression("6", true)}
        btn7.setOnClickListener{appendOnExpression("7", true)}
        btn8.setOnClickListener{appendOnExpression("8", true)}
        btn9.setOnClickListener{appendOnExpression("9", true)}
        btn0.setOnClickListener{appendOnExpression("0", true)}
        btnDot.setOnClickListener{appendOnExpression(".", true)}

        //operator

        btnPlus.setOnClickListener{appendOnExpression("+", true)}
        btnDivide.setOnClickListener{appendOnExpression("/", true)}
        btnMinus.setOnClickListener{appendOnExpression("-", true)}
        btnMultiply.setOnClickListener{appendOnExpression("*", true)}

        btnClear.setOnClickListener {
            Text.text = ""
            TextResult.text = ""
        }

        btnBack.setOnClickListener {
            val s = Text.text.toString()
            if (s.isNotEmpty()){
                Text.text = s.substring(0, s.length-1)
            }
            TextResult.text = ""

        }

        btnEqual.setOnClickListener{
            try {
                val expression = ExpressionBuilder(Text.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result ==  longResult.toDouble())
                    TextResult.text = longResult.toString()

                else
                    TextResult.text = result.toString()



            }
            catch (e:Exception){
                Log.d("Exception", "message : " + e.message)
            }
        }




    }



    fun appendOnExpression (string: String, canClear : Boolean){

        if (TextResult.text.isNotEmpty()){
            Text.text = ""
        }

        if(canClear){
            TextResult.text = ""
            Text.append(string)
        }
        else{
            Text.append(TextResult.text)
            Text.append(string)
            Text.text = ""
        }
    }


}

