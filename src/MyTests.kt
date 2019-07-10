import junit.framework.Assert.assertTrue
import junit.framework.Assert.fail
import org.junit.Test
import kotlin.test.assertEquals


class MyTests {

    val one = Songs("One", "Metallica", 10, 50)
    val warriors = Songs("Warriors", "Imagine Dragons", 20, 70)
    val rome = Songs("Rome", "Blackout Problems", 30, 90)

    @Test // Testet ob die richtigen Elemente an der richtigen Stelle sind
    fun testAddSorted() {
        val list = mutableListOf<Songs>()
        val testComp = BewertungCompare()
        var tree = DataNode(one)
        tree = tree.addSorted(rome, testComp)
        tree = tree.addSorted(warriors, testComp)
        tree.forEachSong { list.add(it) }

        assertEquals (list[0].titel , "One")
        assertEquals (list[1].titel , "Warriors")
        assertEquals (list[2].titel , "Rome")
    }

    @Test
    fun testSize() {
        var tree = DataNode(one, DataNode(warriors), DataNode(rome))

        assertEquals (tree.size() , 3)
        //fail("Noch nicht implementiert")
    }

    @Test
    fun testSpieldauer() {
        var tree = DataNode(one, DataNode(warriors), DataNode(rome))

        assertEquals (tree.spieldauer() , 60)
    }

    @Test // Testet, ob in der Liste alle Elemente sind
    fun testForEachSong() {
        val list = mutableListOf<Songs>()
        val testComp = BewertungCompare()
        var tree = DataNode(one)
        tree = tree.addSorted(rome, testComp)
        tree = tree.addSorted(warriors, testComp)
        tree.forEachSong { list.add(it) }

        assertEquals (list.size , 3)

    }

}