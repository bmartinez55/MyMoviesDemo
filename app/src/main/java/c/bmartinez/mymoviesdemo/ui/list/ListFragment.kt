package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.*
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {

    private lateinit var movieListVM: MainViewModel
    private var movieData: ArrayList<Movies> = arrayListOf()
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
        movieListVM.popularMoviesLiveData.observe(this, Observer {
            for(x in it){
                Log.d("DATA: ", x.title)
            }
            movieData.addAll(it.toList())
            if(movieData.isEmpty()) Toast.makeText(context,"Empty Array", Toast.LENGTH_LONG).show()
        })
    }

    private fun setUpRecyclerView(recyclerView: RecyclerView){
        recyclerView.adapter = ListAdapter(requireContext(), movieData)
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