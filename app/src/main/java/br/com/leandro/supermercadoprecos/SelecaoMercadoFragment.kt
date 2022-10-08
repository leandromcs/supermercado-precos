package br.com.leandro.supermercadoprecos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.leandro.supermercadoprecos.adapter.MercadosAdapter
import br.com.leandro.supermercadoprecos.databinding.FragmentSelecaoMercadoBinding
import br.com.leandro.supermercadoprecos.viewmodel.SelecaoMercadoViewModel

class SelecaoMercadoFragment : Fragment() {

    private lateinit var binding: FragmentSelecaoMercadoBinding

    private val viewModel: SelecaoMercadoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelecaoMercadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.consultarMercados()

        viewModel.consultaResult.observe(viewLifecycleOwner) {
            binding.rvMercados.apply {
                layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
                adapter = MercadosAdapter(it)
            }
        }
    }
}