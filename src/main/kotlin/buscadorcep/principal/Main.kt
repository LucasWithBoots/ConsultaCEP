package buscadorcep.principal

import buscadorcep.servicos.Buscador
import java.util.Scanner

fun main() {
    val entrada = Scanner(System.`in`)

    println("Digite o seu CEP: ")
    val cepParaBuscar = entrada.nextLine()

    val buscador = Buscador(entrada)
    buscador.jsonParaClassEndereco(cepParaBuscar)

}