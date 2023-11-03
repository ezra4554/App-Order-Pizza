package com.example.mypzaa

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val dataList: List<DataModel>, private val context: Context, private val packageContext: Context): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_menu, parent, false)
        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item, context, packageContext)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val linearLayout: LinearLayout = itemView.findViewById(R.id.layoutItems)
        private val imageView: ImageView = itemView.findViewById(R.id.imgMenu)
        private val textViewTitle: TextView = itemView.findViewById(R.id.titleMenu)
        private val textViewDescription: TextView = itemView.findViewById(R.id.descMenu)
        private val noItemOrder: TextView = itemView.findViewById(R.id.noItemOrder)

        fun bind(dataModel: DataModel, context: Context, packageContext: Context) {
            imageView.setImageResource(dataModel.imageResource)
            textViewTitle.text = dataModel.title
            textViewDescription.text = dataModel.description

            if(dataModel.orderCount == 0){
                noItemOrder.visibility = View.GONE;
            }else{
                noItemOrder.visibility = View.VISIBLE;
                noItemOrder.text = dataModel.orderCount.toString()
            }
            linearLayout.setOnClickListener {
                dataModel.orderCount++
                noItemOrder.visibility = View.VISIBLE;
                noItemOrder.text = dataModel.orderCount.toString()
                val intent = Intent(packageContext, DetailMenu::class.java)
                intent.putExtra("NAME_TXT", dataModel.nameTxt)
                intent.putExtra("SELECTED_CITY", dataModel.cityTxt)
                intent.putExtra("TITLE_MENU", dataModel.title)
                packageContext.startActivity(intent, null)
                Toast.makeText(context, "CLICKED", Toast.LENGTH_SHORT).show()
            }
        }
    }
}