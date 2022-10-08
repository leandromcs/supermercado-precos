package br.com.leandro.supermercadoprecos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.leandro.supermercadoprecos.`interface`.OnResultListener
import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.model.Produto
import br.com.leandro.supermercadoprecos.repository.CadastroRepository
import br.com.leandro.supermercadoprecos.repository.HomeRepository

class HomeViewModel : ViewModel(), OnResultListener {

    private val repository = HomeRepository()

    private val _consultaResult : MutableLiveData<ArrayList<Produto>> = MutableLiveData()
    val consultaResult : LiveData<ArrayList<Produto>> = _consultaResult

    fun consultarProdutos(nomeDoMercado: String) {
        repository.consultarProdutos(nomeDoMercado, this)
    }

    override fun onSuccessListener(produtos: ArrayList<Produto>) {
        _consultaResult.value = produtos
    }

    override fun onSuccessListenerMercado(mercados: ArrayList<Mercado>) {
        TODO("Not yet implemented")
    }

    override fun onSuccessListenerCadastro(isSuccess: Boolean) {
        TODO("Not yet implemented")
    }
}