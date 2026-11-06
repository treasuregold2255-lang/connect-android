package com.example.connect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.NetworkCheck
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Navy = Color(0xFF090F1C)
private val Cyan = Color(0xFF45D9F2)
private val Muted = Color(0xFFB6C2D2)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { ConnectScreen() }
    }
}

@Composable
fun ConnectScreen() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            background = Navy,
            surface = Color(0xFF151F30),
            primary = Cyan,
            onBackground = Color.White,
            onSurface = Color.White
        )
    ) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Navy
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp, vertical = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(24.dp))
                Text(
                    "CONNECT",
                    color = Cyan,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 4.sp
                )
                Spacer(Modifier.height(12.dp))
                Text(
                    "Your internet,\nyour connection.",
                    color = Color.White,
                    fontSize = 31.sp,
                    lineHeight = 37.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(42.dp))

                Box(
                    modifier = Modifier
                        .size(188.dp)
                        .background(Color(0xFF10283A), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Box(
                        modifier = Modifier
                            .size(156.dp)
                            .background(Color(0xFF17384B), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Default.NetworkCheck,
                            contentDescription = "Network",
                            tint = Cyan,
                            modifier = Modifier.size(66.dp)
                        )
                    }
                }

                Spacer(Modifier.height(22.dp))
                Text(
                    "Subscription required",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(8.dp))
                Text(
                    "Your secure connection will activate after your subscription is verified and a network gateway is configured.",
                    color = Muted,
                    fontSize = 13.sp,
                    lineHeight = 19.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.widthIn(max = 300.dp)
                )

                Spacer(Modifier.height(34.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFF141F30), RoundedCornerShape(18.dp))
                        .padding(18.dp),
                    verticalArrangement = Arrangement.spacedBy(18.dp)
                ) {
                    FeatureRow(Icons.Default.VerifiedUser, "Automatic connection after subscription")
                    FeatureRow(Icons.Default.Refresh, "Reconnect when network changes")
                    FeatureRow(Icons.Default.Lock, "Encrypted connection")
                }

                Spacer(Modifier.weight(1f))
                Text(
                    "PREVIEW VERSION  •  INTERNET GATEWAY NOT CONNECTED",
                    color = Color(0xFF718096),
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center,
                    letterSpacing = 0.5.sp
                )
            }
        }
    }
}

@Composable
private fun FeatureRow(icon: androidx.compose.ui.graphics.vector.ImageVector, label: String) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null, tint = Cyan, modifier = Modifier.size(21.dp))
        Spacer(Modifier.width(12.dp))
        Text(label, color = Color.White, fontSize = 13.sp)
    }
}
