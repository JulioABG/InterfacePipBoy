package com.example.pipboyinterface

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pipboyinterface.ui.theme.PipBoyInterfaceTheme // Ojo al nombre de tu tema
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.pipboyinterface.ui.theme.PipBoyInterfaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Aquí le decimos que use nuestro tema personalizado
            PipBoyInterfaceTheme {
                // Y aquí llamamos a la pantalla principal que creamos
                PipBoyScreen()
            }
        }
    }
}