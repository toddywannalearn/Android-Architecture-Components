package com.games.livscorporation.archcompsample

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel: ScoreViewModel by lazy {
        ViewModelProviders.of(this).get(ScoreViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_teamA.setOnClickListener { viewModel.updateTeamA() }
        btn_TeamB.setOnClickListener { viewModel.updateTeamB() }
        btn_reset.setOnClickListener { viewModel.reset() }

        viewModel.scoreTeamA.observe(this, Observer { value ->
            txt_teamA.text = value.toString()
        })
        viewModel.scoreTeamB.observe(this, Observer {value ->
            txt_teamB.text = value.toString()
        })
    }
}
