package com.epifi.assignment.model

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Element(
    /** Basic Info **/

    @PrimaryKey
    @SerializedName("imdbID")
    var imdbId: String = "",

    @SerializedName("Title")
    var title: String? = null,

    @SerializedName("Year")
    var year: String? = null,

    @SerializedName("Type")
    var _searchType: String? = null,

    @SerializedName("Poster")
    var poster: String? = null,

    /** Advanced Info **/

    @SerializedName("Rated")
    var rated: String? = null,

    @SerializedName("Released")
    var released: String? = null,

    @SerializedName("Runtime")
    var runtime: String? = null,

    @SerializedName("Genre")
    var genre: String? = null,

    @SerializedName("Director")
    var director: String? = null,

    @SerializedName("Writer")
    var writer: String? = null,

    @SerializedName("Actors")
    var actors: String? = null,

    @SerializedName("Plot")
    var plot: String? = null,

    @SerializedName("Language")
    var language: String? = null,

    @SerializedName("Country")
    var country: String? = null,

    @SerializedName("Awards")
    var awards: String? = null,

    @Ignore
    @SerializedName("Ratings")
    var ratings: List<Rating>? = null,

    @SerializedName("Metascore")
    var metaScore: String? = null,

    @SerializedName("imdbRating")
    var imdbRating: String? = null,

    @SerializedName("imdbVotes")
    var imdbVotes: String? = null,

    @SerializedName("DVD")
    var dvd: String? = null,

    @SerializedName("BoxOffice")
    var boxOffice: String? = null,

    @SerializedName("Production")
    var production: String? = null,

    @SerializedName("Website")
    var website: String? = null,

    @Ignore
    @SerializedName("Response")
    private var _response: String? = null,

    /** Local Info **/

    @SerializedName("bookmarked")
    var isBookmarked: Boolean = false,
) : Parcelable {

    val cast
        get() = try {
            actors?.split(",")?.joinToString("\n") { it.trim() }
        } catch (e: Throwable) {
            actors
        }

    val searchType
        get() = try {
            SearchType.valueOf(_searchType!!)
        } catch (e: Throwable) {
            null
        }

    val randomRating
        get() = try {
            ratings?.random()
        } catch (e: Throwable) {
            null
        }

    val response
        get() = _response?.toBoolean()

    class DIffCallback : DiffUtil.ItemCallback<Element>() {
        override fun areItemsTheSame(oldItem: Element, newItem: Element): Boolean {
            return oldItem.imdbId == newItem.imdbId
        }

        override fun areContentsTheSame(oldItem: Element, newItem: Element): Boolean {
            return oldItem == newItem
        }
    }

    companion object {
        const val KEY_ELEMENT = "element"
    }

}
