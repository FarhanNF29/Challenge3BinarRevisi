package com.example.challenge3binar

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.challenge3binar.databinding.FragmentDetailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentDetail.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentDetail : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setOnClickLocation()


        val bundle = Bundle()
        val food = arguments?.getParcelable<DataMenu>("DataMenu")
        if(food != null){
            val gambarMenu:ImageView = binding.ivMenuDetail
            val namaMenu:TextView = binding.tvNamaMenuDetail
            val hargaMenu:TextView = binding.tvHargaMenuDetail
            val deskripsi:TextView = binding.tvDeskripsiMenu
            val lokasi:TextView = binding.tvLokasiDetail

            gambarMenu.setImageResource(food.img)
            namaMenu.text = food.nameMenu
            hargaMenu.text = food.hargaMenu
            deskripsi.text = food.deskripsi
            lokasi.text = food.lokasi
        }

    }



    private fun setOnClickLocation(){
        view?.findViewById<TextView>(R.id.tv_lokasiDetail)?.setOnClickListener{
            navigateToMaps()
        }
    }

    private fun navigateToMaps(){
        val direct = Intent(
            Intent.ACTION_VIEW,
            Uri.parse("https://maps.app.goo.gl/h4wQKqaBuXzftGK77")
        )
        startActivity(direct)
    }

    companion object {

    }
}