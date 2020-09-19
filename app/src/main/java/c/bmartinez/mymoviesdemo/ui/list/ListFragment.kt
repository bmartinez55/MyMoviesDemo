package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel

class ListFragment: Fragment() {

    private lateinit var movieListVM: MainViewModel
    private var movieData: ArrayList<Movies> = arrayListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = rootView.findViewById(R.id.movieList) as RecyclerView

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListVM = ViewModelProvider(this).get(MainViewModel::class.java)

        setUpUI()
        checkData()
        adapter = ListAdapter(requireContext(), movieData)
        linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        adapter.notifyDataSetChanged()


    }

    private fun setUpUI(){
        movieListVM.popularMoviesLiveData.observe(this, Observer {
            movieData.addAll(it.toList())
        })
    }

    private fun checkData(){
        if(movieData.isEmpty()){ Toast.makeText(context,"Data was not retrieved", Toast.LENGTH_LONG).show()}
        else { Toast.makeText(context, "Data retrieval was a success!", Toast.LENGTH_LONG).show() }
    }
}