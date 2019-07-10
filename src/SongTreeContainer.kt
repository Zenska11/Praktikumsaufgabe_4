sealed class Tree {
    abstract fun addSorted(song : Songs , comp : Comparator <Songs>) : Tree

    abstract fun size () : Int

    abstract fun spieldauer() : Int

    abstract fun forEachSong(f : ( song : Songs ) -> Unit)
}

object EmptyTree : Tree() {
    override fun addSorted(song : Songs , comp : Comparator <Songs>) = DataNode (song)

    override fun size() = 0

    override fun spieldauer() = 0

    override fun forEachSong(f : ( song : Songs ) -> Unit) {}
}

class DataNode (val song : Songs, val left : Tree = EmptyTree, val right : Tree = EmptyTree) : Tree() {

    override fun addSorted(newSong : Songs, comp : Comparator <Songs>)  =
        if ( comp.compare(newSong, song) <=0 )
            DataNode (song , left.addSorted(newSong, comp) ,right )
        else
            DataNode (song , left , right.addSorted(newSong, comp))

    override fun size() = left.size() + 1 + right.size()

    override fun spieldauer() = left.spieldauer() + song.spieldauer + right.spieldauer()

    override fun forEachSong(f : ( song : Songs ) -> Unit) {
        left.forEachSong(f)     // erst den linken Teilbaum verarbeiten
        f ( this.song)          // diesen Knoten verarbeiten
        right.forEachSong(f)    // rechten Teilbaum verarbbeiten
    }
}
