package br.com.leandro.supermercadoprecos.repository

import android.util.Log
import br.com.leandro.supermercadoprecos.`interface`.OnResultListener
import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.model.Produto
import br.com.leandro.supermercadoprecos.viewmodel.HomeViewModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.gson.Gson
import org.json.JSONObject

class HomeRepository {

    fun consultarProdutos(nomeDoMercado: String, onResultListener: OnResultListener) {
        val db = Firebase.firestore
        val gson = Gson()
        val produtos: ArrayList<Produto> = ArrayList()

        db.collection("mercados").document(nomeDoMercado).collection("produtos")
            .get()
            .addOnSuccessListener { result ->
                if (result != null) {
                    for (document in result.documents) {
                        val produto = gson.fromJson(document.data?.let { JSONObject(it).toString() }, Produto::class.java)
                        produtos.add(produto)
                    }
                    onResultListener.onSuccessListener(produtos)
                }
            }
            .addOnFailureListener { e ->
                Log.w("Failure Firestore", "Error adding document", e)
            }
    }
}