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
import c.bmartinez.mymoviesdemo.data.Movies
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ListAdapter(private val context: Context ,private val movies: List<Movies>): RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView? = null
        var imgView: ImageView? = null
        var genreTextView: TextView? = null
        var dateReleaseTextView: TextView? = null
        var shortTextView: TextView? = null

        init {
            titleTextView = itemView.findViewById(R.id.titleMovie)
            imgView = itemView.findViewById(R.id.moviePoster)
            genreTextView = itemView.findViewById(R.id.genreTextView)
            dateReleaseTextView = itemView.findViewById(R.id.dateRelease)
            shortTextView = itemView.findViewById(R.id.shortTextView)
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
        //holder.genreTextView!!.text = convertGenreArrayToString(currentMovie.genres)
        holder.dateReleaseTextView!!.text = changeTimeFormat(currentMovie.release_date).toString()
        //holder.shortTextView!!.text = checkMovieShort(currentMovie.duration)
//        holder.itemView.setOnClickListener {
//            onItemClickListener?.onItemCLick(holder.itemView,position)
//        }
    }

    private fun checkMovieShort(length: String): String{
        val time: Int = length.replace("M","").toInt()

        if(time < 90 ) return "Short"
        else{return "Long"}
    }

    @SuppressLint("SimpleDateFormat")
    private fun changeTimeFormat(time: String): Date {
        val formatter: SimpleDateFormat = SimpleDateFormat("MM-dd-yyyy")
        val createNewDate: Date = formatter.parse(time)

        return createNewDate
    }

    private fun convertGenreArrayToString(genres: List<String>) = genres.joinToString(", ")
    private fun fixDurationFormat(input: String) = input.replace("M"," minutes")

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
