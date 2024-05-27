package buscadorcep.principal

import buscadorcep.servicos.Buscador
import java.util.Scanner

fun main() {
    val entrada = Scanner(System.`in`)
    val buscador = Buscador(entrada)

    do {
        println("Digite o seu CEP: ")
        val cepParaBuscar = entrada.nextLine()
        buscador.jsonParaClassEndereco(cepParaBuscar)

        println("Deseja buscar outro CEP? S/N")
        val opcaoParaContinuar = entrada.nextLine()
    } while ((opcaoParaContinuar.equals("s", true)))

    buscador.exibirCepsBuscados()
}