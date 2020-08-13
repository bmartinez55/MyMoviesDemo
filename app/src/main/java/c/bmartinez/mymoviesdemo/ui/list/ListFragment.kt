package c.bmartinez.mymoviesdemo.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import c.bmartinez.mymoviesdemo.R

class ListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_list, container,false)
        val recyclerView: RecyclerView = view.findViewById(R.id.movieList)
        val adapter = ListAdapter()
        recyclerView.adapter = adapter
        val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        return view
    }
}