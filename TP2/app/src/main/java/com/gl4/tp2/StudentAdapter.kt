package com.gl4.tp2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*

class StudentAdapter (private val data : Array<MainActivity.Student>) : RecyclerView.Adapter<StudentAdapter.ViewHolder>(), Filterable {

    //create ViewHolder and declare val with _item.xml
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageStudentId)
        val textView: TextView = itemView.findViewById(R.id.textStudentId)
    }

    //create first method
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.student_item, parent, false)
        return ViewHolder(view)
    }
    //create second method : bind val of holder with data
    override fun onBindViewHolder(holder: StudentAdapter.ViewHolder, position: Int) {
        holder.textView.text = data[position].name + " " + data[position].lastName
        if (data[position].gendre == "male") {
            holder.imageView.setBackgroundResource(R.drawable.man)
        }
        else if (data[position].gendre == "female") {
            holder.imageView.setBackgroundResource(R.drawable.woman)
        }
    }
    //create third method : return number of item
    override fun getItemCount(): Int {
        return data.size
    }

    //Filter
    var dataFilter = arrayOf<MainActivity.Student>()
    init {
        dataFilter = data
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()
                if (charSearch.isEmpty()) {
                    dataFilter = data
                } else {
                    val resultList = arrayOf<MainActivity.Student>()
                    for (student in data) {
                        if (student.name.lowercase(Locale.ROOT)
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList[resultList.size]=student
                        }
                    }
                    dataFilter = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = dataFilter
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                dataFilter = results?.values as Array<MainActivity.Student>
                notifyDataSetChanged()
            }
        }
    }
}
