package com.maximasistemas.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.maximasistemas.App
import com.maximasistemas.adapter.ProductAdapter
import com.maximasistemas.R
import kotlinx.android.synthetic.main.activity_tela1.*

class Tela1Activity : AppCompatActivity() {

    //TODO: LIFE CYCLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela1)
    }

    override fun onStart() {
        super.onStart()

        configRecycler()

    }

    //TODO: CONFIG VIEW

    private fun configRecycler() {

        val listProduct = ArrayList<ProductAdapter.ProductModel>()

        App.database?.readProduto()?.forEach {

            listProduct.add(ProductAdapter.ProductModel(it.id.toString(), it.descricao.toString(), it.fornecedor, R.mipmap.ic_launcher_round))
        }

        recycler_view.layoutManager = LinearLayoutManager(this)
        recycler_view.adapter = ProductAdapter(listProduct)

    }
}
