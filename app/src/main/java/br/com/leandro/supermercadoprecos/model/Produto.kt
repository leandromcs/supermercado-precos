package br.com.leandro.supermercadoprecos.model

data class Produto(
    val nome: String,
    val img: String,
    val preco: String,
    val codBarra: String? = null
)
