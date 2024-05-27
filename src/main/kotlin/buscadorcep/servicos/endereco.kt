package buscadorcep.servicos

data class endereco(
    val cep: String?, val logradouro: String?, val bairro: String?,
    val uf: String?, val ibge: Number?, val gia: String?, val ddd: Number?, val siafi: Number?
) {
    override fun toString(): String {
        return "Cep=$cep\n" +
                "logradouro=$logradouro\n" +
                "bairro=$bairro\n" +
                "uf=$uf\n" +
                "ibge=$ibge\n" +
                "gia=$gia\n" +
                "ddd=$ddd\n" +
                "siafi=$siafi"
    }
}


