package org.sgod.jioai

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        val btn = Button(this).apply {
            text = "Start Floating Predictor"
            setOnClickListener {
                if (Settings.canDrawOverlays(this@MainActivity)) {
                    startService(Intent(this@MainActivity, FloatingService::class.java))
                    Toast.makeText(this@MainActivity, "Service Started!", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    val intent = Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                        Uri.parse("package:$packageName"))
                    startActivity(intent)
                }
            }
        }
        setContentView(btn)
    }
}
