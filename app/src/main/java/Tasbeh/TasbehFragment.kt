package Tasbeh

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamic.R
import com.example.islamic.databinding.FragmntTasbehBinding

class TasbehFragment : Fragment() {
lateinit var binding: FragmntTasbehBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmntTasbehBinding.inflate(layoutInflater)
       inflater.inflate(R.layout.fragment_hadeth, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         var numbertasbeh :Int =0
    binding.textsebha.setOnClickListener(View.OnClickListener{
        binding.numberSebha.text=(numbertasbeh+1).toString()
        numbertasbeh++
    })

    }
}
