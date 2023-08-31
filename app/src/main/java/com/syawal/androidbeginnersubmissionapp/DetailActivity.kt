package com.syawal.androidbeginnersubmissionapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_TEAM = "key_team"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imgTeam: ImageView = findViewById(R.id.img_detail_photo)
        val tvTeamName: TextView = findViewById(R.id.tv_detail_team)
        val tvTeamDesc: TextView = findViewById(R.id.tv_detail_desc)

        val teamData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Teams>(KEY_TEAM, Teams::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Teams>(KEY_TEAM)
        }

        if (teamData != null) {
            supportActionBar?.title = teamData.name

            Glide.with(this)
                .load(teamData.photo)
                .into(imgTeam)

            tvTeamName.text = teamData.name
            tvTeamDesc.text = teamData.desc
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT, "This is share function")
                shareIntent.type = "text/plain"
                startActivity(Intent.createChooser(shareIntent, "Share This"))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}