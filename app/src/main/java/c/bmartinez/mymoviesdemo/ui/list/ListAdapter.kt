package c.bmartinez.mymoviesdemo.ui.list

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
import java.util.Collections.addAll

class ListAdapter(private val movies: List<Movies>): RecyclerView.Adapter<ListAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(movie: Movies){
            itemView.apply {
                Glide.with(moviePoster.context).load(movie.posterUrl).into(moviePoster)
            }
        }
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
