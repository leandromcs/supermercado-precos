package br.com.leandro.supermercadoprecos.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.supermercadoprecos.R
import br.com.leandro.supermercadoprecos.model.Mercado
import com.google.gson.Gson

class MercadosAdapter(private val dataSet: ArrayList<Mercado>) :
    RecyclerView.Adapter<MercadosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNome: TextView

        init {
            tvNome = view.findViewById(R.id.tv_nome)
        }

        fun bind(mercado: Mercado, itemView: View) {
            tvNome.text = mercado.nome
            tvNome.setOnClickListener {
                val navController = Navigation.findNavController(itemView)
                val bundle = Bundle()
                val gson = Gson()
                bundle.putString("mercado", gson.toJson(mercado))
                navController.navigate(R.id.action_SecondFragment_to_FirstFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.mercado_view_holder, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position], viewHolder.itemView)
    }

    override fun getItemCount() = dataSet.size

}