package com.example.collegeprofile

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToProfile = findViewById<Button>(R.id.btnGoToProfile)
        val btnGoToGithub = findViewById<Button>(R.id.btnGoToGithub)

        btnGoToProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java).apply {
                putExtra("EXTRA_NIM", "L0124098")
                putExtra("EXTRA_NAMA", "Fadholi Rizqi Novandra Atmaja")
                putExtra("EXTRA_JURUSAN", "Informatika")
                putExtra("EXTRA_ANGKATAN", "2024")
                putExtra("EXTRA_DESKRIPSI", "Mahasiswa Universitas Sebelas Maret yang memiliki ketertarikan di bidang Cybersecurity Programming dan pengembangan aplikasi Android.")
            }
            startActivity(intent)
        }

        btnGoToGithub.setOnClickListener {
            val githubUrl = "https://github.com/atmajafadholi00-rgb"

            val webIntent = Intent(Intent.ACTION_VIEW, Uri.parse(githubUrl))
            startActivity(webIntent)
        }
    }
}