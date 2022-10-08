package br.com.leandro.supermercadoprecos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.leandro.supermercadoprecos.`interface`.OnResultListener
import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.model.Produto
import br.com.leandro.supermercadoprecos.repository.CadastroRepository
import br.com.leandro.supermercadoprecos.repository.HomeRepository
import br.com.leandro.supermercadoprecos.repository.SelecaoMercadoRepository

class SelecaoMercadoViewModel : ViewModel(), OnResultListener {

    private val repository = SelecaoMercadoRepository()

    private val _consultaResult : MutableLiveData<ArrayList<Mercado>> = MutableLiveData()
    val consultaResult : LiveData<ArrayList<Mercado>> = _consultaResult

    fun consultarMercados() {
        repository.consultarMercados(this)
    }

    override fun onSuccessListener(produtos: ArrayList<Produto>) {
        TODO("Not yet implemented")
    }

    override fun onSuccessListenerMercado(mercados: ArrayList<Mercado>) {
        _consultaResult.value = mercados
    }

    override fun onSuccessListenerCadastro(isSuccess: Boolean) {
        TODO("Not yet implemented")
    }
}