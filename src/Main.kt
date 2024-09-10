fun main() {
    val Candidatos = arrayOf(
        Candidato("Candidato 1"),
        Candidato("Candidato 2"),
        Candidato("Candidato 3")
    )
    var totalvotosgenerales=0
    while (true) {
        println("\nMenu:")
        println("0) Consultar Candidatos")
        println("1) Votar por un candidato")
        println("2) Costo de Campaña por votacion")
        println("3) Vaciar urnas de votacion")
        println("4) Total de votos")
        println("5) porcentaje de votos por candidato")
        println("6) costo promedio de campaña")
        println("7) Candidato Ganador")
        println("8) Salir")
        println("Elige una opcion")
        when (readLine()?.toIntOrNull()) {
            0 -> {
                Candidatos.forEach {
                    println(it.nombre)
                }
            }
            1 -> {
                println("Elige un candidato(1, 2, 3): ")
                val candidatoelegido = readLine()?.toIntOrNull()?.minus(1)
                if (candidatoelegido in 0..2) {
                    println("Medio de influencia (1-Internet, 2-Radio, 3-Television): ")
                    when(readLine()?.toIntOrNull()){
                        1 -> Candidatos[candidatoelegido!!].votosinternet++
                        2 -> Candidatos[candidatoelegido!!].votosradio++
                        3 -> Candidatos[candidatoelegido!!].votostelevision++
                        else -> println("Opcion no valida")
                    }
                    totalvotosgenerales++
                    println("Voto Registrado Correctamente")
                }
                else{
                    println("Candidato No Valido")
                }
            }
            2 -> {
                println("Costo de Campaña por Candidato:")
                Candidatos.forEach {
                    println("${it.nombre}: \$${it.costocampaña()}")
                }
            }
            3 -> {
                Candidatos.forEach {
                    it.votosinternet =0
                    it.votosradio = 0
                    it.votostelevision = 0
                }
                totalvotosgenerales = 0
                println("Urnas Vaciadas")
            }
            4 -> {
                println("Total de votos: $totalvotosgenerales")
            }
            5 -> {
                println("Porcentaje de votos por candidato:")
                Candidatos.forEach {
                    println("${it.nombre}: ${"%.2f".format(it.porcentajevotos(totalvotosgenerales))}%")
                }
            }
            6 -> {
                val CostoTotal = Candidatos.sumOf { it.costocampaña() }
                val CostoPromedio =if (totalvotosgenerales == 0) 0.0 else CostoTotal.toDouble() / totalvotosgenerales
                println("Costo promedio de campaña por voto: \\\$${"%.2f".format(CostoPromedio)}")
            }
            7 -> {
                val ganador = obtenerCandidatoGanador(Candidatos)
                if (ganador != null) {
                    println("El candidato ganador es ${ganador.nombre} con ${ganador.totalvotos()} votos.")
                } else {
                    println("No hay votos registrados.")
                }
            }
            8 -> {
            println("Saliendo...")
            return
        }
            else -> println("Opción no válida.")
        }
    }
}


