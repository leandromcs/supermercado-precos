package br.com.leandro.supermercadoprecos.repository

import br.com.leandro.supermercadoprecos.`interface`.OnResultListener
import br.com.leandro.supermercadoprecos.model.Mercado
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CadastroRepository {

    fun salvar(mercado: Mercado, onResultListener: OnResultListener) {
        val db = Firebase.firestore

        val mercadoMap = hashMapOf(
            "nome" to mercado.nome
        )

        val produtoMap = hashMapOf(
            "nome" to mercado.produtos[0].nome,
            "img" to mercado.produtos[0].img,
            "preco" to mercado.produtos[0].preco,
            "codBarra" to mercado.produtos[0].codBarra
        )

        db.collection("mercados").document(mercado.nome)
            .set(mercadoMap)
            .addOnSuccessListener {

                db.collection("mercados").document(mercado.nome).collection("produtos")
                    .add(produtoMap)
                    .addOnSuccessListener {
                        onResultListener.onSuccessListenerCadastro(true)
                    }
                    .addOnFailureListener {
                        onResultListener.onSuccessListenerCadastro(false)
                    }

            }
            .addOnFailureListener {
                onResultListener.onSuccessListenerCadastro(false)
            }
    }
}