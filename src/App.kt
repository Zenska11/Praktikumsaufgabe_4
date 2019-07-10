class BewertungCompare : Comparator<Songs> {
    override fun compare(a: Songs , b : Songs): Int {
        return a.bewertung - b.bewertung
    }
}

fun main() {
    // Musikverwaltung
    val bibList = mutableListOf<Songs>()
    val mv = Musikverwaltung(bibList)

    val one = Songs("One", "Metallica", 300, 170)
    val warriors = Songs("Warriors", "Imagine Dragons", 256, -100)
    val rome = Songs("Rome", "Blackout Problems", 128, 15)
    val people = Songs("People", "Leoniden", 315, 95)
    val goodbye = Songs("Goodbye", "SR-71", 180, 60)
    val mother = Songs("Mother", "Lissie", 400, 90)
    val happyHome = Songs("Happy Home", "Lukas Graham", 440, 99)
    val sevenYears = Songs("7 Years", "Lukas Graham", 330, 100)

    // Song mit Text
    val rockYouLikeAHurricane = SongMitText("Rock You Like a Hurricane", "The Scorps", 340, 5, "It's early morning, the sun comes out")
    // Song mit auto Bewertung
    val heroesTonight = SongMitAutoBewertung("Heroes Tonight", "Johnning", 300, 66)

    mv.addSong(one)
    mv.addSong(warriors)
    mv.addSong(rome)
    mv.addSong(people)
    mv.addSong(goodbye)
    mv.addSong(mother)
    mv.addSong(happyHome)
    mv.addSong(sevenYears)
    mv.addSong(rockYouLikeAHurricane)
    mv.addSong(heroesTonight)

    // Liste für Playlist
    val songliste = mutableListOf<Songs>()
    songliste.add(one)
    songliste.add(people)
    songliste.add(happyHome)
    // Übergibt die Liste für die Playlist und erstellt diese
    // val bestofZenska = Playlist(songliste)

    // Tree //

    val comp = BewertungCompare()
    var tree = DataNode(mother)
    tree = tree.addSorted(sevenYears, comp)
    tree = tree.addSorted(happyHome, comp)
    tree = tree.addSorted(warriors, comp)
    tree = tree.addSorted(heroesTonight, comp)

    println(tree.size())
    println(tree.spieldauer())
    tree.forEachSong { println("${it.titel} mit einer Bewertung von: ${it.bewertung}")}


    // Neue Playlist Dynamic Playlist
    println()

//    val pl3 = DynamicPlaylist(songliste)
//
//    println("Vor dem Reset:")
//    //pl3.addSong(rockYouLikeAHurricane)  // SongMitText
//    //pl3.addSong(heroesTonight)          // SongMitAutoBewertung
//    //pl3.addSonglast(mother)
//    //pl3.removeSong()                    // Löscht den ersten Song, liefert auch den gelöschten Song
//    pl3.addSonglast(heroesTonight)
//    pl3.addSonglast(one)
//    pl3.alleAbspielen()
//
//    println("Gesamtspieldauer: ${pl3.gesamtspieldauer()}")
//
//    println()
//
//    println("Nach dem Reset:")
//    pl3.reset()                         // stellt die default Playlist wieder her
//    pl3.alleAbspielen()
//    println("Gesamtspieldauer: ${pl3.gesamtspieldauer()}")
//    println()

    // Zufällige Playlist erstellen
//    val zufallsplaylist = mv.zufallPlaylist()
//
//    // Beide Playlists abspielen
//    println("Eigene Playlist:")
//    bestofZenska.alleAbspielen()
//    println()
//    println("Zufällige Playlist:")
//    zufallsplaylist.alleAbspielen()
//
//    // Bester Song
//    println()
//    println("Bester Song: ")
//    println("Bester Song: ${mv.bestSong().titel} von ${mv.bestSong().interpret} mit ${mv.bestSong().bewertung} Punkten")
//    println()


//    do {
//
//        println("Bitte geben Sie einen Suchbegriff ein: ")
//        val benutzereingabe = readLine().toString()
//        if (benutzereingabe != "stopp") { // Damit nicht nochmal ein Song abgespielt wird, wenn man stopp eingegeben hat.
//            var gefundenerSong: Songs? = mv.searchSong(benutzereingabe)
//            if (gefundenerSong != null) {
//                gefundenerSong.abspielen()
//            } else {
//                println("Song nicht gefunden")
//            }
//
//            println()
//        }
//
//    } while (benutzereingabe != "stopp")
}