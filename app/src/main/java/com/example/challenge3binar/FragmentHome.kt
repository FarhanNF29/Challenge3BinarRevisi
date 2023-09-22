package com.example.challenge3binar

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.challenge3binar.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHome.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHome : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private var isGrid = true
    private var listMenu: ArrayList<DataMenu> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listDataMenu = arrayListOf(
            DataMenu(R.drawable.ayam_bakar, "Ayam Goreng", "Rp. 50.000", "Ayam Goreng khas gorengan dengan minyak bimoli.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345"),
            DataMenu(R.drawable.ayam_geprek, "Ayam Geprek", "Rp. 45.000", "Ayam Geprek khas geprekan dengan cabai merah.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345"),
            DataMenu(R.drawable.ayam_bakar_ori, "Ayam Bakar", "RP. 45.000", "Ayam Bakar khas bakaran dengan sambal bakar yang dicampur aduk.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345"),
            DataMenu(R.drawable.ayam_rica, "Ayam Rica-rica", "Rp. 55.000", "Ayam Rica-Rica khas sambal dengan kepedasan ekstra.","Jl. BSD Green Office Park Jl. BSD Grand Boulevard, Sampora, BSD, Kabupaten Tangerang, Banten 15345")
        )
        listMenu.clear()
        listMenu.addAll(listDataMenu)
        setupRecyclerView(isGrid, listMenu)
        setupActionChangeLayout()


    }

    fun setupRecyclerView(isGrid: Boolean, data: ArrayList<DataMenu>) {
        val adapterMenu = Adapaters(data, isGrid)
        binding.recycleView.adapter = adapterMenu
        if (isGrid) {
            binding.recycleView.layoutManager = GridLayoutManager(context, 2)
        } else {
            binding.recycleView.layoutManager = LinearLayoutManager(context)
        }

        adapterMenu.onItemClick = {
            val nBundle = Bundle()
            nBundle.putParcelable("DataMenu", it)
            findNavController().navigate(R.id.action_fragmentHome_to_fragmentDetail, nBundle)
        }
    }

    fun setupActionChangeLayout() {
        //button diklik
        binding.imageView7.setOnClickListener {
            isGrid = !isGrid
            setupRecyclerView(isGrid, listMenu)
        }
    }

}