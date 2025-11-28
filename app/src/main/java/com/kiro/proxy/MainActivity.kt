package com.kiro.proxy

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private val HOST = "여기에_너_서버_IP"   // ← 여기만 바꿔!!!
    private val PORT = 8888

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(colorScheme = darkColorScheme(primary = Color(0xFF00D4FF))) {
                var on by remember { mutableStateOf(false) }
                Box(Modifier.fillMaxSize().background(Color(0xFF0D1117)), Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(painterResource(R.drawable.icon), "Kiro Proxy", Modifier.size(140.dp))
                        Spacer(Modifier.height(30.dp))
                        Text("Kiro Proxy", fontSize = 52.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFF00D4FF))
                        Spacer(Modifier.height(80.dp))
                        Button(
                            onClick = { on = !on
                                startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                                Toast.makeText(this@MainActivity, "설정에서 호스트: $HOST 포트: $PORT 입력!", Toast.LENGTH_LONG).show()
                            },
                            Modifier.size(220.dp),
                            shape = CircleShape,
                            colors = ButtonDefaults.buttonColors(containerColor = if(on) Color(0xFF00FF88) else Color(0xFF2383E2))
                        ) {
                            Text(if(on) "CONNECTED" else "CONNECT", fontSize = 32.sp, color = Color.Black)
                        }
                        Spacer(Modifier.height(40.dp))
                        Text(if(on) "연결됨!" else "터치해서 연결", color = if(on) Color(0xFF00FF88) else Color.Gray, fontSize = 22.sp)
                    }
                }
            }
        }
    }
}
