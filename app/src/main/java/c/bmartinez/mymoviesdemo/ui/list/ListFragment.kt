package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.ui.details.DetailsFragment
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel

class ListFragment: Fragment() {

    private var movieListVM: MainViewModel? = null
    private var movieData: ArrayList<Movies> = arrayListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = ListAdapter(movieData)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView: View = inflater.inflate(R.layout.fragment_list,container,false)

        linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL

        recyclerView = rootView.findViewById(R.id.movieList)!!
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter
        return rootView
    }

    override fun onStart() {
        super.onStart()
        setUpUI()
        checkData()
    }

    private fun setUpUI(){
        movieListVM?.getMovies()
        movieListVM?.savedMovies?.observe(this, Observer(function = fun(movieList: List<Movies>?){
            for(i in movieList!!){
                movieData.add(i)
            }
            movieList.let{
                adapter.setItemClickListener(object: ListAdapter.ItemClickListener{
                    override fun onItemCLick(view: View, position: Int) {
                        val newFragment = DetailsFragment.newInstance(movieList.get(position))
                        val transaction = fragmentManager!!.beginTransaction()
                            .addToBackStack(null).commit()
                    }
                })
            }
        }))
    }

    private fun checkData(){
        for(i in movieData){
            Log.i("DATA", i.title)
        }
    }
}