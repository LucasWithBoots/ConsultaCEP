package buscadorcep.servicos

fun String.formatacaoPadrao(): String {
    return if (this.matches(Regex("^[0-9]{5}-[0-9]{3}$"))) {
        this.replace("-", "")
    } else {
        this
    }
}