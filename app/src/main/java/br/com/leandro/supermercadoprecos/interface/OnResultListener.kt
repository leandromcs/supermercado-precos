package br.com.leandro.supermercadoprecos.`interface`

import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.model.Produto

interface OnResultListener {
    fun onSuccessListener(produtos: ArrayList<Produto>)
    fun onSuccessListenerMercado(mercados: ArrayList<Mercado>)
    fun onSuccessListenerCadastro(isSuccess: Boolean)
}