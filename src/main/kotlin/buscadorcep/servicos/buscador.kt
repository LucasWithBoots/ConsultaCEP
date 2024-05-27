package buscadorcep.servicos

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers


class buscador {

    fun buscaCep(cep: String): String? {
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
            gson.fromJson(json, endereco::class.java)
        }.onSuccess { enderecoObjeto ->
            println(enderecoObjeto)
        }.onFailure { ex ->
            println("Erro ao buscar ou converter o CEP: ${ex.message}")
        }
    }
}