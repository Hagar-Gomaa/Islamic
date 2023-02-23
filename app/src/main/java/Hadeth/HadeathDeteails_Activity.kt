package Hadeth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islamic.R
import com.example.islamic.Ui.Constants
import com.example.islamic.databinding.ActivityHadeathDeteailsBinding
import com.example.islamic.databinding.ActivitySuraDeteailsBinding
import quran.SuraAdapter
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class HadeathDeteails_Activity : AppCompatActivity() {

    lateinit var binding : ActivityHadeathDeteailsBinding
    lateinit var suraAdapter: SuraAdapter
    lateinit var suraList :List<String>
    lateinit var name: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHadeathDeteailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pos: Int = intent.getIntExtra(Constants.EXTRA_Hadeath_POS, 0)
        readSura(pos)
        suraAdapter = SuraAdapter(suraList)
        binding.recycleHadeath.adapter = suraAdapter
        binding.hadeathnameDetailsActivity.text=name
    }

    fun readSura(pos: Int){
        val myLines = mutableListOf<String>()
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(assets.open("h${pos + 1}.txt")))
            var mLine: String?
            var i =1
            while (reader.readLine().also { mLine = it } != null) {
                if (i==1){name= mLine.toString()
              i++ }
               else myLines.add("{$mLine}")

            }
        } catch (e: IOException) {
            Log.e("sura-details", "error reading file");
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                }
            }}

        suraList = myLines;
    }

}