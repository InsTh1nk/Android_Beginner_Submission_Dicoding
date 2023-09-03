package com.syawal.androidbeginnersubmissionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvTeams: RecyclerView
    private val list = ArrayList<Teams>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "F1 TEAMS"

        rvTeams = findViewById(R.id.rv_teams)
        rvTeams.setHasFixedSize(true)

        list.addAll(getListTeam())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about_menu -> {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListTeam(): Collection<Teams> {
        val teamName = resources.getStringArray(R.array.f1_team)
        val carPhoto = resources.getStringArray(R.array.teams_logo)
        val descData = resources.getStringArray(R.array.desc)
        val listTeams = ArrayList<Teams>()
        for (i in teamName.indices) {
            val team = Teams(teamName[i], carPhoto[i], descData[i])
            listTeams.add(team)
        }
        return listTeams
    }

    private fun showRecyclerList() {
        rvTeams.layoutManager = LinearLayoutManager(this)
        val listTeamsAdapter = ListTeamsAdapter(list)
        rvTeams.adapter = listTeamsAdapter
    }
}