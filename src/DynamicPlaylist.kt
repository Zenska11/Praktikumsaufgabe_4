class DynamicPlaylist (songliste : MutableList<Songs>) : Playlist (songliste){
    init {
        for (s in songliste) {
            addSonglast(s) // falls addSong() dann auch hier ändern
        }
    }

    inner class SongNode (val song : Songs, var nextSong : SongNode?)

    private var first : SongNode? = null
    private var last : SongNode? = null


    fun isEmpty() : Boolean = first == null

    fun addSong(s : Songs) {

        if (isEmpty()) {
            first = SongNode(s, null)
        } else {
            var run = first
            while (run?.nextSong != null) {
                run = run.nextSong
            }
            run?.nextSong = SongNode(s, null)
        }
    }

    fun addSonglast(s : Songs) {

        if (isEmpty()) {
            first = SongNode(s, null)
            last = first
        } else {
            last?.nextSong = SongNode(s, null)
            last = last?.nextSong
        }
    }

    fun removeSong () : Songs? { // returnter Song kann auch null sein, falls die Liste leer ist
        if (isEmpty()) {
            return null
        } else {
            var temp = first
            first = temp?.nextSong
            return temp?.song
        }
    }

    // Setzt die verkettete Liste wieder so her, wie Sie am Anfang übergeben wurde
    fun reset() {
        first = null
        for (s in songliste) {
            addSong(s)
        }
    }

    override fun alleAbspielen() {
        var run = first
        run?.song?.abspielen() // gibt den ersten Knoten aus
        while (run?.nextSong != null) {
            // gibt alle Knoten bis auf den Ersten
            run = run.nextSong
            run?.song?.abspielen()
        }
    }

    override fun gesamtspieldauer() : Int {
        var run = first
        var gesamtspieldauer = 0
        if (isEmpty()) return 0
        else {
            gesamtspieldauer += run?.song?.spieldauer!!
            while (run?.nextSong != null) {
                run = run.nextSong
                gesamtspieldauer += run?.song?.spieldauer!!

            }
        }

        return gesamtspieldauer
    }
}