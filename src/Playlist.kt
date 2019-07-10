open class Playlist(val songliste : MutableList<Songs>) {

    open fun gesamtspieldauer() : Int {
        var gesamtspielzeit = 0
        for (i in songliste) {
            gesamtspielzeit += i.spieldauer
        }
        return gesamtspielzeit
    }

    open fun alleAbspielen(){
        for (i in songliste) {
            i.abspielen()
        }
    }
}