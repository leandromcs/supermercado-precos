package br.com.leandro.supermercadoprecos.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.leandro.supermercadoprecos.R
import br.com.leandro.supermercadoprecos.model.Produto

class ProdutosAdapter(private val dataSet: ArrayList<Produto>) :
    RecyclerView.Adapter<ProdutosAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val tvNome: TextView
        private val tvPreco: TextView
        private val ivProduto: ImageView

        init {
            tvNome = view.findViewById(R.id.tv_nome)
            tvPreco = view.findViewById(R.id.tv_preco)
            ivProduto = view.findViewById(R.id.iv_produto)
        }

        fun bind(produto: Produto) {
            tvNome.text = produto.nome
            tvPreco.text = produto.preco

            val context: Context = ivProduto.context
            val id: Int = context.resources
                .getIdentifier(produto.img, "drawable", context.packageName)
            ivProduto.setImageResource(id)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.produto_view_holder, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

}