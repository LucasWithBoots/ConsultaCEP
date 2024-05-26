package buscadorcep.principal

import buscadorcep.servicos.buscador
import java.util.Scanner

fun main() {
    val entrada = Scanner(System.`in`)

    val cepParaBuscar = entrada.nextLine()

    val buscador = buscador()
    buscador.buscaCep(cepParaBuscar)

}