package c.bmartinez.mymoviesdemo.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import c.bmartinez.mymoviesdemo.R
import c.bmartinez.mymoviesdemo.data.Movies

class DetailsFragment: Fragment() {

    private lateinit var movie: Movies

    companion object{
        const val KEY = "KEY_MOVIES"

//        fun newInstance(movies: Movies): DetailsFragment {
//            val args = Bundle()
//            args.putSerializable(KEY, movies)
//            val fragment = DetailsFragment()
//            fragment.arguments = args
//            return fragment
//        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let{ movie = it.getSerializable(KEY) as Movies}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_details,container,false)
    }
}