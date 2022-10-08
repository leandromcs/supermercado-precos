package br.com.leandro.supermercadoprecos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leandro.supermercadoprecos.adapter.ProdutosAdapter
import br.com.leandro.supermercadoprecos.databinding.FragmentHomeBinding
import br.com.leandro.supermercadoprecos.model.Mercado
import br.com.leandro.supermercadoprecos.viewmodel.HomeViewModel
import com.google.gson.Gson

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.spinner.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        if (arguments?.get("mercado") != null) {
            val gson = Gson()
            val mercado: Mercado = gson.fromJson(arguments?.get("mercado") as String, Mercado::class.java)

            binding.spinner.text = mercado.nome

            viewModel.consultarProdutos(mercado.nome)
        }

        viewModel.consultaResult.observe(viewLifecycleOwner) {
            binding.rvProdutos.apply {
                adapter = ProdutosAdapter(it)
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            }
        }
    }
}