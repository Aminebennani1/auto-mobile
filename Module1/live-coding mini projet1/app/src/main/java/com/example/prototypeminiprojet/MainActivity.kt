package com.example.prototypeminiprojet

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.prototypeminiprojet.ui.theme.PrototypeMiniProjetTheme

private val FontWeight.Companion.Bold: androidx.compose.ui.text.font.FontWeight?
    get() {
        TODO("Not yet implemented")
    }


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PrototypeMiniProjetTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CarteDeVisite()
                }
            }
        }
    }
}

@Composable
fun CarteDeVisite() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Nom et profession
        Text(
            text = "John Doe",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "Développeur Android",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Coordonnées
        val context = LocalContext.current
        val callIntent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:+33612345678")
        }
        ContactInfo(
            label = "Téléphone :",
            value = "+33 6 12 34 56 78",
            onClick = { context.startActivity(callIntent) }
        )
        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:johndoe@example.com")
        }
        ContactInfo(
            label = "Email :",
            value = "johndoe@example.com",
            onClick = { context.startActivity(emailIntent) }
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Bouton pour site web
        Button(onClick = { /* Ouvrir le site */ }) {
            Text("Visiter mon site")
        }
    }
}

@Composable
fun ContactInfo(label: String, value: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(vertical = 4.dp)
    ) {
        Text(text = "$label ", fontWeight = FontWeight.Bold)
        Text(text = value, color = Color.Blue)
    }
}