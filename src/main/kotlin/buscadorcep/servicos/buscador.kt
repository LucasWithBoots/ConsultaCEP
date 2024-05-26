package buscadorcep.servicos

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.net.http.HttpResponse.BodyHandlers


class buscador {
    fun buscaCep(cep: String){
        println("hi")
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://viacep.com.br/ws/$cep/json/"))
            .build()
        client.sendAsync(request, BodyHandlers.ofString())
            .thenApply { obj: HttpResponse<*> -> obj.body() }
            .thenAccept(System.out::println)
            .join()

    }
}