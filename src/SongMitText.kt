class SongMitText(titel : String, interpret : String, spieldauer : Int, bewertung : Int, val text : String)
    : Songs(titel, interpret , spieldauer , bewertung)
{
    override fun suchbegriffUeberpruefen(s : String) : Boolean = (titel.contains(s) || interpret.contains(s) || text.contains(s))
}