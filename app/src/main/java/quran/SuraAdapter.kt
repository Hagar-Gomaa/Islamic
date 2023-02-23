package quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.R

class SuraAdapter(val suraList :List <String>) :RecyclerView.Adapter<SuraAdapter.viewHolder>() {

    class viewHolder (itemview: View):RecyclerView.ViewHolder(itemview){
        val asset :TextView =itemview.findViewById(R.id.asset)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.sura_item, parent, false)
           return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
         holder.asset.text=suraList[position]
    }

    override fun getItemCount(): Int {
      return suraList.size    }
}