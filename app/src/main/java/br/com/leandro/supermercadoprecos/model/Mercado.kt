package br.com.leandro.supermercadoprecos.model


data class Mercado(
    val nome: String,
    val produtos: Array<Produto>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Mercado

        if (nome != other.nome) return false
        if (!produtos.contentEquals(other.produtos)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = nome.hashCode()
        result = 31 * result + produtos.contentHashCode()
        return result
    }
}
