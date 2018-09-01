package com.maximasistemas.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.maximasistemas.R

class ProductAdapter(val listProduct: ArrayList<ProductModel>) : RecyclerView.Adapter<ProductAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listProduct[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imagem = itemView.findViewById<ImageView>(R.id.imageProduct)
        val nome = itemView.findViewById<TextView>(R.id.nomeProduct)
        val fornecedor = itemView.findViewById<TextView>(R.id.distriProduct)

        fun bind(item: ProductModel) {

            imagem.setImageResource(item.imagem)
            nome.text = "${item.codigo} - ${item.descricao}"
            fornecedor.text = item.fornecedor

        }
    }

    class ProductModel(
            val codigo: String,
            val descricao: String,
            val fornecedor: String,
            val imagem: Int
    )
}