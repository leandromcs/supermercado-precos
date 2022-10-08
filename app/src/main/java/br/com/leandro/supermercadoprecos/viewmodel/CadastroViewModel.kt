package br.com.leandro.supermercadoprecos.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.leandro.supermercadoprecos.`interface`.OnResultListener
import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.model.Produto
import br.com.leandro.supermercadoprecos.repository.CadastroRepository

class CadastroViewModel : ViewModel(), OnResultListener {

    private val repository = CadastroRepository()

    private val _cadastroResult : MutableLiveData<Boolean> = MutableLiveData()
    val cadastroResult : LiveData<Boolean> = _cadastroResult

    fun salvar(mercado: Mercado) {
        repository.salvar(mercado, this)
    }

    override fun onSuccessListener(produtos: ArrayList<Produto>) {
        TODO("Not yet implemented")
    }

    override fun onSuccessListenerMercado(mercados: ArrayList<Mercado>) {
        TODO("Not yet implemented")
    }

    override fun onSuccessListenerCadastro(isSuccess: Boolean) {
        _cadastroResult.value = isSuccess
    }

}