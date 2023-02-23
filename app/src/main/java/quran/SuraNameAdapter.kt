package quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.R

class SuraNameAdapter(val suraList :List <String>) :RecyclerView.Adapter<SuraNameAdapter.viewHolder>() {

    class viewHolder (itemview: View):RecyclerView.ViewHolder(itemview){
        val suraname :TextView =itemview.findViewById(R.id.suraname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.suraname_item, parent, false)
           return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
         holder.suraname.text=suraList[position]
        if (onItemClickListener != null)
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, suraList[position])
            }
    }

    override fun getItemCount(): Int {
      return suraList.size    }

    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(pos: Int, item: String)
    }
}