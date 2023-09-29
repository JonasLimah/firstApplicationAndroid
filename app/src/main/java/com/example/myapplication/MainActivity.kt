package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding //criando a variavel bindin para ser usada

    //depois
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//atribuindo o valor a variavel
        setContentView(binding.root)//usando as propriedades do root"raiz"
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate) {
            calculate()
        }
    }
    private fun isValid(): Boolean {
        return  (binding.editDistance.text.toString() != "" &&
                binding.editPrice.text.toString() != "" &&
                binding.editAutonomy.text.toString() != "" &&
                binding.editAutonomy.text.toString().toInt() != 0

                )
    }
    private fun calculate(){
        if(isValid()){
            val distance = binding.editDistance.text.toString().toDouble()//getting distance value
            val price = binding.editPrice.text.toString().toDouble()//getting price value
            val autonomy = binding.editAutonomy.text.toString().toDouble()//getting autonomy value
            val totalValue = (distance*price)/autonomy
            binding.textResult.text = " R$ ${"%.2f".format(totalValue)}"// sempre seleciona o id pelo binding
        }else{
            Toast.makeText(this,"Digite todos os campos",Toast.LENGTH_SHORT).show()
        }




    }
}