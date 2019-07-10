import kotlin.random.Random

class Musikverwaltung (val bibliothek : MutableList<Songs>) {
    fun addSong (song : Songs) = bibliothek.add(song)

    fun searchSong(suchbegriff : String) : Songs? {
        for (aktuellerSong in bibliothek) {
            if (aktuellerSong.suchbegriffUeberpruefen(suchbegriff)) return aktuellerSong
        }
        return null
    }

    fun bestSong () : Songs {
        var besterSong = bibliothek.first()
        for (aktuellerSong in bibliothek) {
            if (aktuellerSong.bewertung > besterSong.bewertung) besterSong = aktuellerSong
        }
        return besterSong
    }

    fun zufallPlaylist() : Playlist {
        val list = mutableListOf<Songs>()
        for (i in 0..bibliothek.size-1) {  // Anzahl der Lieder, die in Zufallsplaylist kommen
            list.add(bibliothek[Random.nextInt(0, bibliothek.size-1)])
        }
        return Playlist(list)
    }
}