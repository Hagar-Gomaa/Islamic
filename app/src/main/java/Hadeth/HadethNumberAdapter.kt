package Hadeth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islamic.R
import quran.SuraNameAdapter

class HadethNumberAdapter(val hadethNumberList :List <String>) :RecyclerView.Adapter<HadethNumberAdapter.viewHolder>() {

    class viewHolder (itemview: View):RecyclerView.ViewHolder(itemview){
        val hadethNumber :TextView =itemview.findViewById(R.id.suraname)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.suraname_item, parent, false)
           return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.hadethNumber.text = hadethNumberList[position]
       if (onItemClickListener !=null){
           holder.itemView.setOnClickListener{
               onItemClickListener!!.onItemClicked(position, hadethNumberList[position])
           }
       }
    }

    override fun getItemCount(): Int {
      return hadethNumberList.size    }

    var onItemClickListener:OnHadethItemClickLiseaner? =null
    interface OnHadethItemClickLiseaner{
        fun onItemClicked(position: Int,items:String){}
    }

}