package com.example.tesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tesouro.ui.theme.TesouroTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
                val navigationController = rememberNavController()
                NavHost(navController = navigationController, startDestination = "tela00") {
                    composable("tela00") {
                        Tela00(
                            { navigationController.navigate("tela01") })
                    }
                    composable("tela01") {
                        Tela01(
                            { navigationController.navigate("tela02") },
                            { navigationController.navigate("tela00") },
                            { navigationController.navigate("tela05") })
                    }
                    composable("tela02") {
                        Tela02(
                            { navigationController.navigate("tela01") },
                            { navigationController.navigate("tela03") },
                            { navigationController.navigate("tela05") })
                    }

                    composable("tela03") {
                        Tela03(
                            { navigationController.navigate("tela02") },
                            { navigationController.navigate("tela04") },
                            { navigationController.navigate("tela05") })
                    }
                    composable("tela04") {
                        Tela04(
                            { navigationController.navigate("tela00") })
                    }
                    composable("tela05") {
                        Tela05(
                            { navigationController.navigate("tela00") })
                    }
                }
            }
        }
    }

@Composable
fun Tela00(onNavigateToScreen01: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.rgb(119, 221, 119))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.wheredidiputmytrasure),
            contentDescription = "Minha Imagem 0",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Inicie a sua caça ao tesouro!!",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp))
        Button(
            onClick = { onNavigateToScreen01() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.6f)
        ) {
            Text(text = "Iniciar")
        }
    }
}


@Composable
fun Tela01(onNavigateToScreen02: () -> Unit, onNavigateToScreen00: () -> Unit, onNavigateToScreen05: () -> Unit) {
    var respostaUsuario by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.rgb(119, 221, 119))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.nerdcat),
            contentDescription = "Minha Imagem 1",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Atualmente, quantos elementos químicos a tabela periódica possui?",
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp))

        OutlinedTextField(
            value = respostaUsuario,
            onValueChange = { respostaUsuario = it },
            label = { Text("Digite a resposta") }
        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { onNavigateToScreen00() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Voltar")
            }
            Button(
                onClick = {
                    if (resposta("1", respostaUsuario)) {
                        onNavigateToScreen02()
                    } else {
                        onNavigateToScreen05()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Avançar")
            }
        }

    }
}


@Composable
fun Tela02(onNavigateToScreen01: () -> Unit, onNavigateToScreen03: () -> Unit,onNavigateToScreen05: () -> Unit) {
    var respostaUsuario by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.rgb(255, 182, 193))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.mathcat),
            contentDescription = "Minha Imagem 2",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Quantos graus são necessários para que dois ângulos sejam complementares?",
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp))

        OutlinedTextField(
            value = respostaUsuario,
            onValueChange = { respostaUsuario = it },
            label = { Text("Digite a resposta") }
        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { onNavigateToScreen01() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Voltar")
            }
            Button(
                onClick = {
                    if (resposta("2", respostaUsuario)) {
                        onNavigateToScreen03()
                    } else {
                        onNavigateToScreen05()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Avançar")
            }
        }

    }
}

@Composable
fun Tela03(onNavigateToScreen02: () -> Unit, onNavigateToScreen04: () -> Unit, onNavigateToScreen05: () -> Unit) {
    var respostaUsuario by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.rgb(255, 182, 193))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.loadingcat),
            contentDescription = "Minha Imagem 2",
            modifier = Modifier.size(200.dp)
        )
        Text(text = " Em que ano foi usado um celular pela primeira vez no Brasil?",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp))

        OutlinedTextField(
            value = respostaUsuario,
            onValueChange = { respostaUsuario = it },
            label = { Text("Digite a resposta") }
        )
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ){
            Button(
                onClick = { onNavigateToScreen02() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text(text = "Voltar")
            }
            Button(
                onClick = {
                    if (resposta("3", respostaUsuario)) {
                        onNavigateToScreen04()
                    } else {
                        onNavigateToScreen05()
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)
            ) {
                Text(text = "Avançar")
            }
        }
    }
}

@Composable
fun Tela04(onNavigateToScreen00: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.rgb(177, 156, 217))),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.goldbrickcat),
            contentDescription = "Minha Imagem 0",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Parabéns!! Pegue seu gatinho",
            fontSize = 27.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp))
        Button(
            onClick = { onNavigateToScreen00() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.6f)
        ) {
            Text(text = "Voltar ao início")
        }
    }
}

@Composable
fun Tela05(onNavigateToScreen00: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.angycat),
            contentDescription = "Minha Imagem 0",
            modifier = Modifier.size(200.dp)
        )
        Text(text = "Você errou, volte ao início.",
            fontSize = 27.sp,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .padding(top = 16.dp)
                .padding(horizontal = 16.dp))
        Button(
            onClick = { onNavigateToScreen00() },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth(0.6f)
        ) {
            Text(text = "Voltar ao início")
        }
    }
}

fun resposta(tela: String, resposta: String): Boolean {
    return when (tela) {
        "1" -> resposta.lowercase() == "118"
        "2" -> resposta.lowercase() == "90"
        "3" -> resposta.lowercase() == "1990"
        else -> false
    }
}
