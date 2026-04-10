package com.example.collegeprofile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.collegeprofile.R

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvProfilData = findViewById<TextView>(R.id.tvProfilData)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnGithub = findViewById<Button>(R.id.btnGithub)

        val nim = intent.getStringExtra("EXTRA_NIM")
        val nama = intent.getStringExtra("EXTRA_NAMA")
        val jurusan = intent.getStringExtra("EXTRA_JURUSAN")
        val angkatan = intent.getStringExtra("EXTRA_ANGKATAN")
        val deskripsi = intent.getStringExtra("EXTRA_DESKRIPSI")


        val profileText = """
            $nim
    
            $nama
    
            $jurusan, $angkatan
    
            $deskripsi
        """.trimIndent()

        tvProfilData.text = profileText

        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Halo! Ini profil saya:\n\n$profileText")
            }
            startActivity(Intent.createChooser(shareIntent, "Bagikan Profil Via..."))
        }

        btnGithub.setOnClickListener {
            val githubUrl = "https://github.com/atmajafadholi00-rgb"
            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
            startActivity(webIntent)
        }
    }
}