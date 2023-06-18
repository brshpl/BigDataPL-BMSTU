package lab4

import java.util.*

/**
 * 4. Создать класс Художественная Выставка с внутренним классом,
 * с помощью объектов которого можно хранить информацию о картинах, авторах и времени проведения выставок.
 */
class ArtExhibition {
    private val exhibitions: HashSet<Exhibition> = HashSet()

    inner class Exhibition(val name: String, val datetime: Date) {
        init {
            exhibitions.add(this)
        }

        private val artworks: HashSet<Artwork> = HashSet()

        fun addArtwork(author: String, name: String) {
            artworks.add(Artwork(author, name))
        }

        fun getArtworkByName(name: String): Artwork? {
            return artworks.firstOrNull { it.name == name }
        }

        fun getArtworksByAuthor(author: String): HashSet<Artwork> {
            return artworks.filter { it.author == author }.toHashSet()
        }

        fun getArtworks(): HashSet<Artwork> {
            return artworks
        }

        inner class Artwork(val author: String, val name: String)
    }
}
