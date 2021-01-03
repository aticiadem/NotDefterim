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
import com.adematici.notdefterim.databinding.ActivityNotDetayBinding

class NotDetayActivity : AppCompatActivity() {

    lateinit var binding: ActivityNotDetayBinding
    val vt = VeritabaniYardimcisi(this)

    var sira: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotDetayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val gelenSira: Int = intent.getIntExtra("pozisyon",0)

        sira = gelenSira

        val tekNot = Notlardao().tekNotGetir(vt,gelenSira)
        binding.etBaslik.setText(tekNot?.not_baslik)
        binding.etIcerik.setText(tekNot?.not_icerik)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_delete -> {
                Notlardao().notSil(vt,sira!!)
                Toast.makeText(this,"Silme İşlemi Başarılı.",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
                return true
            }
            R.id.action_update -> {
                Notlardao().notGuncelle(vt,sira!!,binding.etBaslik.text.toString(),binding.etIcerik.text.toString())
                Toast.makeText(this,"Güncelleme İşlemi Başarılı.",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()
                return true
            }
            else -> {
                Toast.makeText(this,"Silme İşlemi Başarısız.",Toast.LENGTH_SHORT).show()
                return false
            }
        }
    }

}