package com.adematici.notdefterim.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.adematici.notdefterim.adapter.NotlarAdapter
import com.adematici.notdefterim.database.Notlardao
import com.adematici.notdefterim.database.VeritabaniYardimcisi
import com.adematici.notdefterim.databinding.ActivityMainBinding
import com.adematici.notdefterim.model.NotlarModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var notListesi: ArrayList<NotlarModel>
    private lateinit var adapter: NotlarAdapter
    val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarMainActivity)

        notListesi = ArrayList()
        notListesi = Notlardao().tumNotlar(vt)

        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = NotlarAdapter(this,notListesi)
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            startActivity(Intent(this,NotEkleActivity::class.java))
        }

    }
}