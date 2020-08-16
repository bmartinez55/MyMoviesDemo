package c.bmartinez.mymoviesdemo.ui.list

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Movie
import android.text.method.TextKeyListener.clear
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.list_item.view.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.Collections.addAll

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class ListAdapter(private val movies: List<Movies>): RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        fun bind(movie: Movies){
            itemView.apply {
                Glide.with(moviePoster.context).load(movie.posterUrl).into(moviePoster)
                titleMovie.text = movie.title
                dateRelease.text = fixDurationFormat(movie.duration)
                dateRelease.text = movie.releaseData
                genreTextView.text = convertGenreArrayToString(movie.genres)
                dateRelease.text = changeTimeFormat(movie.releaseData).toString()
                shortTextView.text = checkMovieShort(movie.duration)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder =
        MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

//    fun addMovies(movies: List<Movies>){
//        this.movies.apply {
//            clear()
//            addAll(movies)
//        }
//    }
}
