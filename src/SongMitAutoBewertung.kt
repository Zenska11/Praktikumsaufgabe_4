class SongMitAutoBewertung (titel : String, interpret : String, spieldauer : Int, bewertung : Int)
    : Songs(titel, interpret , spieldauer , bewertung)
{
    override fun abspielen() {
        for (i in 0..spieldauer / 60) { // Schleife bis angefangene Minute
            println("Spiele: $titel von $interpret (Bewertung: $bewertung Punkte)")
        }

        if(bewertung < 100) bewertung++
    }
}