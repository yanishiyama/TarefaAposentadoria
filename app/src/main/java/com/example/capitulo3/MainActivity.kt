package com.example.capitulo3

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.capitulo3.databinding.ActivityMainBinding




const val indiceMasculino = 65
const val indiceFeminino = 62

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        //Dados para o spinner
        val Itens = listOf("masculino", "feminino")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Itens)

        binding.spinnerSexo.adapter = adapter


        //Acionando Evento do clique do botao
        binding.buttonCalcular.setOnClickListener {
            val sexoselecionado = binding.spinnerSexo.selectedItem as String
            val idade = binding.editTextIdade.text.toString().toLongOrNull()

            var resultado: Long =0L

            if (idade!= null) {

                //Calculo do MASCULINO
                if(sexoselecionado.trim() =="masculino"){
                    resultado= indiceMasculino - idade

                }else{
                    resultado = indiceFeminino - idade
                }
                if (resultado <= 0){
                binding.textViewResultado.text = "Você já esta aposentado"
                }else{
                    binding.textViewResultado.text = "Faltam $resultado anos para você se aposentar"
                }

            }else{
                binding.textViewResultado.text="Informe Uma Idade"
            }
        }
        }
    }