package com.example.manzararecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.teksatirmanzara.view.*


class ManzaraAdapter(tumManzaralar: ArrayList<manzara>) : RecyclerView.Adapter<ManzaraAdapter.ManzaraViewHolder>() {

    var manzaralar = tumManzaralar


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ManzaraViewHolder {  // -> Inflaterün yapıldığı yer.

        var inflater = LayoutInflater.from(parent.context)
        var teksatirManzara = inflater.inflate(R.layout.teksatirmanzara, parent, false)
        Log.e("RecycleView", "OncreateViewholder tetiklendi.")
        return ManzaraViewHolder(teksatirManzara)
    }

    override fun getItemCount(): Int { // -> Adapter calıştığı an ilk buraya bakar.listede göstermek istediğin sayılara bakar ve ona göre yerleşim hazırlar.
        // GetItemCountu kaç yaparsan eleman listede görünür.
        Log.e("RecycleView", "getitemcount tetiklendi.")
        return manzaralar.size //-> manzaraların size'si kadar dön.
    }

    override fun onBindViewHolder(holder: ManzaraViewHolder, position: Int) {
        //-> Burada atama işlemlerini yapıyoruz.
        var oAnolusturulanManzara = manzaralar.get(position)
        holder.setData(oAnolusturulanManzara, position)


        //holder.manzaraBaslik.text = manzaralar.get(position).baslik
        //holder.manzaraAciklama.text = manzaralar.get(position).aciklama
        //holder.manzaraResim.setImageResource(manzaralar.get(position).resim)
        Log.e("RecycleView", "onBindViewHolder tetiklendi.")

    }

    inner class ManzaraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var teksatirManzara = itemView //as CardView
        var manzaraBaslik = teksatirManzara.tvmanzaraBaslik
        var manzaraAciklama = teksatirManzara.tvmanzaraAciklama
        var manzaraResim = teksatirManzara.imgmanzara
        var btnkopyala = teksatirManzara.btnekle
        var btnsil = teksatirManzara.btnsil

        init {

            Log.e("RecycleView", "ManzaraViewHolder tetiklendi.")
        }

        fun setData(oAnkiManzara: manzara, position: Int) {
            manzaraBaslik.text = oAnkiManzara.baslik
            manzaraAciklama.text = oAnkiManzara.aciklama
            manzaraResim.setImageResource(oAnkiManzara.resim)

            btnkopyala.setOnClickListener {

                manzaralar.add(position,oAnkiManzara)
                notifyItemInserted(position)
                notifyItemRangeChanged(position,manzaralar.size)
                Log.e("deneme", "position kopyala: " + position)
            }
            btnsil.setOnClickListener {
                manzaralar.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position,manzaralar.size)

                Log.e("deneme", "position sil: " + position)
            }
        }

    }


}