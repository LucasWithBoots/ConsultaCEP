package buscadorcep.servicos

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*


class Buscador(private val entrada: Scanner) {

    private val listaCeps = mutableListOf<Endereco>()

    private fun buscaCep(cep: String): String? {
        val endereco = "https://viacep.com.br/ws/$cep/json/"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build()

        val response =
            client.send(request, BodyHandlers.ofString())

        val json = response.body()

        return json
    }

    fun jsonParaClassEndereco(cep: String) {

        runCatching {
            val json = buscaCep(cep)
            val gson = Gson()
            gson.fromJson(json, Endereco::class.java)
        }.onSuccess { enderecoObjeto ->
            println("Dados carregados!\n")

            listaCeps.add(enderecoObjeto)

            println(
                "Logradouro: ${enderecoObjeto.logradouro}\n" +
                        "Bairro: ${enderecoObjeto.bairro}\n" +
                        "Uf: ${enderecoObjeto.uf}"
            )

            println("\nDeseja ver todas as informações? S/N")
            if (entrada.nextLine().equals("s", true)) {
                println(enderecoObjeto)
            }

            println("\nFinalizado com sucesso!")

        }.onFailure { ex ->
            println("Erro ao buscar ou converter o CEP: ${ex.message}")
        }
    }

    fun exibirCepsBuscados() {
        println("\nCEPs válidos buscados:")
        listaCeps.forEach {
            println("${it.cep}")
        }
    }
}