package quran

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.islamic.Ui.Constants
import com.example.islamic.databinding.ActivitySuraDeteailsBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class SuraDeteails : AppCompatActivity() {


    lateinit var binding : ActivitySuraDeteailsBinding
    lateinit var suraAdapter: SuraAdapter
    lateinit var suraList :List<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySuraDeteailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name: String = intent.getStringExtra(Constants.EXTRA_SURA_NAME) ?: "";
        val pos: Int = intent.getIntExtra(Constants.EXTRA_SURA_POS, 0)
           readSura(pos)
        suraAdapter = SuraAdapter(suraList)
        binding.recycleSuraname.adapter = suraAdapter
        binding.suranameDetailsActivity.text=name
        }

    fun readSura(pos: Int){
        val myLines = mutableListOf<String>()
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(assets.open("${pos + 1}.txt")))
            var mLine: String?
            var assetNumber =1
            while (reader.readLine().also { mLine = it } != null) {
                myLines.add("{$mLine}"+ " ($assetNumber)")
                assetNumber++
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
         }}


