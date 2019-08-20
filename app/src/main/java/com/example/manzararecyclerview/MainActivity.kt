package com.example.manzararecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.teksatirmanzara.*

class MainActivity : AppCompatActivity() {

    var tumManzaralar = ArrayList<manzara>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        veriKaynagiDoldur()
        var myadapter = ManzaraAdapter(tumManzaralar)
        rvmanzara.adapter = myadapter

        var linearLayoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rvmanzara.layoutManager = linearLayoutManager

    }

    fun veriKaynagiDoldur(): ArrayList<manzara> {

        tumManzaralar = ArrayList<manzara>()

        var tumresimler = arrayOf(
            R.drawable.thumb_1_0,
            R.drawable.thumb_1_1,
            R.drawable.thumb_1_2,
            R.drawable.thumb_1_3,
            R.drawable.thumb_1_4,
            R.drawable.thumb_1_5,
            R.drawable.thumb_1_6,
            R.drawable.thumb_1_7,
            R.drawable.thumb_1_8,
            R.drawable.thumb_1_9,
            R.drawable.thumb_2_0,
            R.drawable.thumb_2_1,
            R.drawable.thumb_2_2,
            R.drawable.thumb_2_3,
            R.drawable.thumb_2_4,
            R.drawable.thumb_2_5,
            R.drawable.thumb_2_6,
            R.drawable.thumb_2_7,
            R.drawable.thumb_2_8,
            R.drawable.thumb_2_9,
            R.drawable.thumb_3_0,
            R.drawable.thumb_3_1,
            R.drawable.thumb_3_2,
            R.drawable.thumb_3_3,
            R.drawable.thumb_3_4,
            R.drawable.thumb_3_5,
            R.drawable.thumb_3_6,
            R.drawable.thumb_3_7,
            R.drawable.thumb_3_8,
            R.drawable.thumb_3_9,
            R.drawable.thumb_4_0,
            R.drawable.thumb_4_1,
            R.drawable.thumb_4_2,
            R.drawable.thumb_4_3,
            R.drawable.thumb_4_4,
            R.drawable.thumb_4_5,
            R.drawable.thumb_4_6,
            R.drawable.thumb_4_7,
            R.drawable.thumb_4_8,
            R.drawable.thumb_4_9,
            R.drawable.thumb_5_0,
            R.drawable.thumb_5_1,
            R.drawable.thumb_5_2,
            R.drawable.thumb_5_3,
            R.drawable.thumb_5_4,
            R.drawable.thumb_5_5,
            R.drawable.thumb_5_6,
            R.drawable.thumb_5_7,
            R.drawable.thumb_5_8,
            R.drawable.thumb_5_9,
            R.drawable.thumb_6_0,
            R.drawable.thumb_6_1,
            R.drawable.thumb_6_2,
            R.drawable.thumb_6_3,
            R.drawable.thumb_6_4,
            R.drawable.thumb_6_5,
            R.drawable.thumb_6_6,
            R.drawable.thumb_6_7,
            R.drawable.thumb_6_8,
            R.drawable.thumb_6_9,
            R.drawable.thumb_7_0,
            R.drawable.thumb_7_1,
            R.drawable.thumb_7_2,
            R.drawable.thumb_7_3,
            R.drawable.thumb_7_4
        )


        for (i in 0..tumresimler.size - 1) {

            var atanacakManzara = manzara("Manzara " + i, "Açıklama " + i, tumresimler[i])
            tumManzaralar.add(atanacakManzara)
        }
        return tumManzaralar


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean { //-> Menulerle calısırken bu fonksyon çalıştırılır.

        menuInflater.inflate(R.menu.anamenu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id: Int = item.itemId
        when (id) {

            R.id.MenulinearViewHorizontal -> {
                var linearLayoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
                rvmanzara.layoutManager = linearLayoutManager
            }

            R.id.MenulinearViewvertical -> {
                var MenulinearViewHorizontal = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                rvmanzara.layoutManager = MenulinearViewHorizontal

            }
            R.id.MenuGrid -> {
                var MenuGrid = GridLayoutManager(this,2)
                rvmanzara.layoutManager = MenuGrid

            }
            R.id.MenustaggeredHorizontal -> {
                var MenustaggeredHorizontal = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
                rvmanzara.layoutManager = MenustaggeredHorizontal
            }
            R.id.MenustaggeredVertical -> {
                var MenustaggeredVertical = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                rvmanzara.layoutManager = MenustaggeredVertical
            }

        }
        return super.onOptionsItemSelected(item)
    }

}
