package buscadorcep.servicos

data class Endereco(
    val cep: String?, val logradouro: String?, val bairro: String?,
    val uf: String?, val ibge: Number?, val gia: String?, val ddd: Number?, val siafi: Number?
) {
    override fun toString(): String {
        return "Cep: $cep\n" +
                "Logradouro: $logradouro\n" +
                "Bairro: $bairro\n" +
                "Uf: $uf\n" +
                "Ibge: $ibge\n" +
                "Gia: $gia\n" +
                "Ddd: $ddd\n" +
                "Siafi: $siafi"
    }
}


