package c.bmartinez.mymoviesdemo.ui.list

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.graphics.Movie
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.MovieData
import c.bmartinez.mymoviesdemo.data.Movies
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Collections.addAll

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ListAdapter(private val movies: List<MovieData>): RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(movie: MovieData){
            itemView.apply {
                movie.movies.forEach {it ->
                    Glide.with(moviePoster.context).load(it.posterurl).into(moviePoster)
                    titleMovie.text = it.title
                    genreTextView.text = convertGenreArrayToString(it.genres)
                    dateRelease.text = changeTimeFormat(it.releasedata).toString()
                    shortTextView.text = checkMovieShort(it.duration)
                }

            }
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
    }

    //private var onItemClickListener: ItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
//        holder.itemView.setOnClickListener {
//            onItemClickListener?.onItemCLick(holder.itemView,position)
//        }
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
