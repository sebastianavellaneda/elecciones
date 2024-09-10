class Candidato(val nombre:String) {
    var votosinternet=0
    var votosradio=0
    var votostelevision=0
    fun totalvotos():Int{
        return votosinternet+votostelevision+votosradio
    }
    fun costocampaña():Int{
        return votosinternet*700000+votostelevision*600000+votosradio*200000
    }
    fun  porcentajevotos(totalvotosgenerales:Int):Double{
        return if (totalvotosgenerales == 0)0.0 else(totalvotos().toDouble()/totalvotosgenerales)*100
    }

    }
fun obtenerCandidatoGanador(candidatos: Array<Candidato>): Candidato? {
    val ganador = candidatos.maxByOrNull { it.totalvotos() }
    return if (ganador != null && ganador.totalvotos() > 0) ganador else null
}