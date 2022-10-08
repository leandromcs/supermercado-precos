package br.com.leandro.supermercadoprecos

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import br.com.leandro.supermercadoprecos.databinding.FragmentCadastroBinding
import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.model.Produto
import br.com.leandro.supermercadoprecos.viewmodel.CadastroViewModel

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding

    private val viewModel: CadastroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.get("codBarras") != null) {
            binding.etCodBarras.setText(arguments?.get("codBarras") as String)
            binding.etCodBarras.isEnabled = false
        }

        binding.btnSalvar.setOnClickListener {
            if (binding.etNome.text.isNotEmpty() && binding.etValor.text.isNotEmpty() && binding.etLocal.text.isNotEmpty() && binding.etCodBarras.text.isNotEmpty()) {
                val produto = Produto(nome = binding.etNome.text.toString(), img = "biscoito", preco = binding.etValor.text.toString(), codBarra = binding.etCodBarras.text.toString())
                val mercado = Mercado(nome = binding.etLocal.text.toString(), produtos = arrayOf(produto))
                viewModel.salvar(mercado)
            }
        }

        viewModel.cadastroResult.observe(viewLifecycleOwner) {
            if (it) {
                AlertDialog.Builder(context).setMessage("Cadastro realizado com Sucesso").setPositiveButton("Ok") { dialog, id ->
                    findNavController().navigate(R.id.action_ThirdFragment_to_FirstFragment)
                }.create().show()
            }
        }
    }
}