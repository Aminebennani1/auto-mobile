package com.example.tuto3plus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InteractiveButtonsApp()
        }
    }

    @Composable
    fun InteractiveButtonsApp() {
        MaterialTheme {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    OpenWebsiteButton()
                    SendEmailButton()
                    DialPhoneNumberButton()
                }
            }
        }
    }

    @Composable
    fun OpenWebsiteButton() {
        val context = LocalContext.current // Get the current context
        Button(onClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            context.startActivity(intent) // Use the context to start the activity
        }) {
            Text("Open Website")
        }
    }

    @Composable
    fun SendEmailButton() {
        val context = LocalContext.current // Get the current context
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:test@example.com")
                putExtra(Intent.EXTRA_SUBJECT, "Email Subject")
            }
            context.startActivity(intent) // Use the context to start the activity
        }) {
            Text("Send Email")
        }
    }

    @Composable
    fun DialPhoneNumberButton() {
        val context = LocalContext.current // Get the current context
        Button(onClick = {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+123456789"))
            context.startActivity(intent) // Use the context to start the activity
        }) {
            Text("Dial Phone Number")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun PreviewInteractiveButtonsApp() {
        InteractiveButtonsApp()
    }
}

