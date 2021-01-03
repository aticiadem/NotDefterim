package com.adematici.notdefterim.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.adematici.notdefterim.R
import com.adematici.notdefterim.database.Notlardao
import com.adematici.notdefterim.database.VeritabaniYardimcisi
import com.adematici.notdefterim.databinding.ActivityNotEkleBinding

class NotEkleActivity : AppCompatActivity() {

    lateinit var binding: ActivityNotEkleBinding
    lateinit var baslik: String
    lateinit var icerik: String
    private val vt = VeritabaniYardimcisi(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotEkleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbarNotEkle)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.action_add -> {
                baslik = binding.etBaslik.text.toString()
                icerik = binding.etIcerik.text.toString()
                if(binding.etBaslik.text.isNotEmpty() && binding.etIcerik.text.isNotEmpty()){
                    Notlardao().notEkle(vt,baslik,icerik)
                    Toast.makeText(this,"Kayıt Başarılı",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,MainActivity::class.java))
                    finish()
                    return true
                }
                else{
                    Toast.makeText(this,"Lütfen Başlık ve İçerik Giriniz.",Toast.LENGTH_SHORT).show()
                    return true
                }
            }
            else -> {
                return false
            }
        }
    }

}