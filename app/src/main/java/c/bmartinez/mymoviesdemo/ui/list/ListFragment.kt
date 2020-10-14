package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {

    companion object {
        private const val LOG_TAG = "ListFragment"
    }

    private lateinit var movieListVM: MainViewModel
    private var movieData: ArrayList<Movies> = arrayListOf()
    private var movieGenreMap: HashMap<Int,String> = mapOf<Int,String>() as HashMap<Int, String>
    //private lateinit var linearLayoutManager: LinearLayoutManager
    //private lateinit var adapter: ListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_list,container,false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieListVM = ViewModelProvider(this).get(MainViewModel::class.java)

        setUpRecyclerView(movieList)
        setUpUI()
    }

    private fun setUpUI(){
        movieListVM.fetchMovies().observe(this, Observer { movieData.addAll(it.results.toList()) })
        movieListVM.fetchMovieGenres().observe(this, Observer {
            for(x in it.genres){
                movieGenreMap[x.id] = x.name
            }
        })
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView){
        recyclerView.adapter = ListAdapter(requireContext(), movieData, movieGenreMap)
        //recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(activity)
        //linearLayoutManager = LinearLayoutManager(activity)
        //linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.setHasFixedSize(true)
        //recyclerView.layoutManager = linearLayoutManager
        //adapter.notifyDataSetChanged()
        (recyclerView.adapter as ListAdapter).notifyDataSetChanged()
    }
}