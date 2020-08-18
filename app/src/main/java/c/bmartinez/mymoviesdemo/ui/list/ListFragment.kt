package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies
import c.bmartinez.mymoviesdemo.ui.details.DetailsFragment
import c.bmartinez.mymoviesdemo.ui.viewmodels.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ListFragment: Fragment() {

    private val movieListVM: MainViewModel by viewModel()
    private var movieData: List<Movies> = listOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list,container,false)
    }

    override fun onStart() {
        super.onStart()
        setUpUI()
    }

    private fun setUpUI(){
        val recyclerView = view?.findViewById<RecyclerView>(R.id.movieList)
        recyclerView!!.layoutManager = LinearLayoutManager(view!!.context,LinearLayoutManager.VERTICAL,false)

        movieListVM.getMovies()
        movieListVM.savedMovies.observe(this, Observer(function = fun(movieList: List<Movies>?){
            movieList?.let{
                val adapter: ListAdapter = ListAdapter(movieList)
                recyclerView.adapter = adapter
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
}