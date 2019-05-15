package com.example.kotlinmotivation.mock

import com.example.kotlinmotivation.util.MotivationConstants
import java.util.*

class Phrase(val  description: String, val category: Int)


class Mock {

    private val mList: List<Phrase> = listOf(
        Phrase("Contente-se com o que tem; ninguém pode ter tudo - (Esopo).",  MotivationConstants.PHRASE_FILTER.ALL),
        Phrase("O homem prudente não diz tudo quanto pensa, mas pensa tudo quanto diz - (Aristóteles)",  MotivationConstants.PHRASE_FILTER.ALL),
        Phrase("O segredo de aborrecer é dizer tudo - (Voltaire).",  MotivationConstants.PHRASE_FILTER.ALL),
        Phrase("A razão é filha do tempo e tudo espera de seu pai - (Voltaire).",  MotivationConstants.PHRASE_FILTER.ALL),
        Phrase("Os amigos têm tudo em comum. A amizade é a igualdade - ( Pitágoras).",  MotivationConstants.PHRASE_FILTER.ALL),

        Phrase("Golpeie quando o ferro estiver quente - (Provérbios alemão).",  MotivationConstants.PHRASE_FILTER.PUBLIC),
        Phrase("Nem todo dia se come pão quente - (Provérbio).",  MotivationConstants.PHRASE_FILTER.PUBLIC),
        Phrase("Água fria sarna cria; água quente, nem a são nem a doente - (Provérbio).",  MotivationConstants.PHRASE_FILTER.PUBLIC),
        Phrase("Ande eu quente, ria-se a gente - (Provérbio).",  MotivationConstants.PHRASE_FILTER.PUBLIC),
        Phrase("Nem pão quente, nem vinho que salte ao dente - (Provérbio portugues).",  MotivationConstants.PHRASE_FILTER.PUBLIC),

        Phrase("Dinheiro não traz felicidade, mas ajuda a sofrer com conforto - (Provérbio).",  MotivationConstants.PHRASE_FILTER.HAPPY),
        Phrase("A alegria é uma careta; a felicidade, um sorriso - (Provérbio).",  MotivationConstants.PHRASE_FILTER.HAPPY),
        Phrase("A felicidade e o desejo, não podem juntar-se - (Provérbio).",  MotivationConstants.PHRASE_FILTER.HAPPY),
        Phrase("Uma felicidade nunca vem só - (Provérbio).",  MotivationConstants.PHRASE_FILTER.HAPPY)

    )


    fun getPhrase(value : Int): String{

        val filtred = mList.filter { it -> it.category == value || value == MotivationConstants.PHRASE_FILTER.ALL}

        val rand = Random().nextInt(filtred.size)

        return filtred.get(rand).description

    }

}