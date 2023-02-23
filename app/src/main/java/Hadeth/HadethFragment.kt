package Hadeth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamic.R
import com.example.islamic.Ui.Constants
import com.example.islamic.databinding.FragmentHadethBinding

class HadethFragment: Fragment() {

lateinit var  HadethNumberAdapter:HadethNumberAdapter
lateinit var list:ArrayList<String>
lateinit var binding: FragmentHadethBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        inflater.inflate(R.layout.fragment_hadeth, container, false)
        binding=FragmentHadethBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      list = ArrayList<String>()
      list= createhadethlist()
      HadethNumberAdapter=HadethNumberAdapter(list)
        binding.recycleHadethnumber.adapter =HadethNumberAdapter

        HadethNumberAdapter.onItemClickListener =object :HadethNumberAdapter.OnHadethItemClickLiseaner{
            override fun onItemClicked(position: Int, items: String) {
                super.onItemClicked(position, items)
            val intent = Intent(activity,HadeathDeteails_Activity::class.java)
            val hadeathName =intent.putExtra(Constants.EXTRA_Hadeath_NAME,list[position])
            val  pos  =intent.putExtra(Constants.EXTRA_Hadeath_POS,position)
           startActivity(intent)
            }
        }
    } fun createhadethlist():ArrayList<String>{
        for (i in 1..50) {
            list.add(" الحديث رقم$i ")}
        return list}


}