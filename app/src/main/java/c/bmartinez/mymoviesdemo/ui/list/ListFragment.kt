package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel
import c.bmartinez.mymoviesdemo.ui.viewmodels.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment: Fragment() {

    private var movieListVM: MainViewModel? = null
    private var movieData: ArrayList<Movies> = arrayListOf()
    private lateinit var recyclerView: RecyclerView
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var adapter: ListAdapter

    private fun setupRecyclerView(){
        if(adapter == null){
            adapter = ListAdapter(requireContext(), movieData)
            linearLayoutManager = LinearLayoutManager(activity)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recyclerView.setHasFixedSize(true)
            recyclerView.layoutManager = linearLayoutManager
        }else{
            adapter.notifyDataSetChanged()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = rootView.findViewById(R.id.movieList) as RecyclerView

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieListVM = activity?.run{ ViewModelProviders.of(this)[MainViewModel::class.java] }?:
            throw Exception("Invalid Activity")

        setupRecyclerView()
        setUpUI()
        checkData()
    }

//    override fun onStart() {
//        super.onStart()
//
//    }

    private fun setUpUI(){
        movieListVM?.movieDataVM?.observe(this, Observer {
            movieData.add(it)
            recyclerView.adapter?.notifyDataSetChanged()
        })
//        movieListVM?.savedMovies?.observe(this, Observer(function = fun(movieList: List<Movies>?){
//            for(i in movieList!!){
//                movieData.add(i)
//            }
////            movieList.let{
//////                adapter.setItemClickListener(object: ListAdapter.ItemClickListener{
//////                    override fun onItemCLick(view: View, position: Int) {
//////                        val newFragment = DetailsFragment.newInstance(movieList.get(position))
//////                        val transaction = fragmentManager!!.beginTransaction()
//////                            .addToBackStack(null).commit()
//////                    }
//////                })
//////            }
//        }))
    }

    private fun checkData(){
        if(movieData.isEmpty()){ Toast.makeText(context,"Data was not retrieved", Toast.LENGTH_LONG).show()}
        else { Toast.makeText(context, "Data retrieval was a success!", Toast.LENGTH_LONG).show() }
    }
}