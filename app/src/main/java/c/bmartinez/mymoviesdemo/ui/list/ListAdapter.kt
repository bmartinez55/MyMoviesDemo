package c.bmartinez.mymoviesdemo.ui.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.MovieGenre
import c.bmartinez.mymoviesdemo.data.Movies
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ListAdapter(private val context: Context, private val movies: List<Movies>,
    private val movieGenres: HashMap<Int,String>): RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView? = null
        var imgView: ImageView? = null
        var genreTextView: TextView? = null
        var dateReleaseTextView: TextView? = null
        var adultTextView: TextView? = null

        init {
            titleTextView = itemView.findViewById(R.id.titleMovie)
            imgView = itemView.findViewById(R.id.moviePoster)
            genreTextView = itemView.findViewById(R.id.genreTextView)
            dateReleaseTextView = itemView.findViewById(R.id.dateRelease)
            adultTextView = itemView.findViewById(R.id.adultTextView)
        }
    }

    //private var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie: Movies = movies[position]
        Glide.with(holder.imgView!!.context).load("http://image.tmdb.org/t/p/w500${currentMovie.poster_path}").into(holder.imgView!!)
        holder.titleTextView!!.text = currentMovie.title
        holder.genreTextView!!.text = convertGenreArrayToString(currentMovie.genresIDs)
        holder.dateReleaseTextView!!.text = changeTimeFormat(currentMovie.release_date).toString()
        holder.adultTextView!!.text = checkAdultMovie(currentMovie.adult)
//        holder.itemView.setOnClickListener {
//            onItemClickListener?.onItemCLick(holder.itemView,position)
//        }
    }

    private fun checkAdultMovie(check: Boolean): String {
        return if (check) "Adult 18+"
        else { "Suitable for certain ages" }
    }

    @SuppressLint("SimpleDateFormat")
    private fun changeTimeFormat(time: String): Date {
        val formatter: SimpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
        val createNewDate: Date = formatter.parse(time)

        return createNewDate
    }

    private fun convertGenreArrayToString(genres: List<Int>): String {
        for(x in genres){
            if(movieGenres.containsKey(x)){
                return movieGenres[x].toString()
            }
        }
        return ""
    }
//    fun setItemClickListener(clickListener: ItemClickListener){
//        onItemClickListener = clickListener
//    }
//    interface ItemClickListener{
//        fun onItemCLick(view: View, position: Int)
//    }

//    fun addMovies(movies: List<Movies>){
//        this.movies.apply {
//            clear()
//            addAll(movies)
//        }
//    }
}
