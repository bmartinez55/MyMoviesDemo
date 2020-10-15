package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.util.Log
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
    private var movieGenreMap: HashMap<Int,String> = HashMap()
    private lateinit var adapter: ListAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)
        recyclerView = view.findViewById(R.id.movieList)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter.apply { context?.let { ListAdapter(it,movieData,movieGenreMap) } }
        return view
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        movieListVM = ViewModelProvider(this).get(MainViewModel::class.java)

        //setUpRecyclerView()
        setUpUI()
        checkData()
    }

    private fun setUpUI(){
        movieListVM.fetchMovies().observe(this, Observer { movieData.addAll(it.results.toList()) })
        movieListVM.fetchMovieGenres().observe(this, Observer {
            for(x in it.genres){
                movieGenreMap[x.id] = x.name
            }
        })
    }

//    private fun setUpRecyclerView(){
//        recyclerView = view!!.findViewById(R.id.movieList)
//        recyclerView.layoutManager = LinearLayoutManager(activity)
//        adapter = ListAdapter(requireContext(),movieData,movieGenreMap)
//        recyclerView.adapter = adapter
//        //recyclerView.adapter!!.notifyDataSetChanged()
//    }

    private fun checkData(){
        for(x in movieGenreMap){
            Log.i(LOG_TAG, x.value)
        }
    }
}