package c.bmartinez.mymoviesdemo.ui.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ListAdapter(private val context: Context, private val movies: List<Movies>,
    private val movieGenres: HashMap<Int,String>): RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var titleTextView: TextView = itemView.findViewById(R.id.titleMovie)
        var imgView: ImageView = itemView.findViewById(R.id.moviePoster)
        var genreTextView: TextView = itemView.findViewById(R.id.genreTextView)
        var dateReleaseTextView: TextView? = itemView.findViewById(R.id.dateRelease)
        var adultTextView: TextView? = itemView.findViewById(R.id.adultTextView)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, "You clicked on item #${position + 1}", Toast.LENGTH_LONG).show()
            }
        }
    }

    private var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie: Movies = movies[position]
        Glide.with(holder.imgView.context).load("http://image.tmdb.org/t/p/w500${currentMovie.poster_path}").into(holder.imgView!!)
        holder.titleTextView.text = currentMovie.title
        holder.genreTextView.text = convertGenreArrayToString(currentMovie.genresIDs)
        holder.dateReleaseTextView!!.text = changeTimeFormat(currentMovie.release_date).toString()
        holder.adultTextView!!.text = checkAdultMovie(currentMovie.adult)
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemCLick(holder.itemView,position)
        }
    }

    private fun checkAdultMovie(check: Boolean): String {
        return if (check) "Adult 18+"
        else { "Suitable for certain ages" }
    }

    @SuppressLint("SimpleDateFormat")
    private fun changeTimeFormat(time: String): Date {
        val formatter = SimpleDateFormat("MM-dd-yyyy")
        return formatter.parse(time)
    }

    private fun convertGenreArrayToString(genres: List<Int>): String {
        var genreStr: String = ""
        for(x in genres){
            if(movieGenres.containsKey(x)){ genreStr = "$x, " }
        }
        return genreStr.dropLast(2)
    }
    fun setItemClickListener(clickListener: ItemClickListener){
        onItemClickListener = clickListener
    }
    interface ItemClickListener{
        fun onItemCLick(view: View, position: Int)
    }
}
