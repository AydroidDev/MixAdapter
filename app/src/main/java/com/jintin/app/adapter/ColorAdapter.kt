package com.jintin.app.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jintin.app.R

/**
 * multiple view holder type example
 */
class ColorAdapter(private val context: Context, private val items: List<Color>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun getItemViewType(position: Int): Int {
        return position % 3 + 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder? {
        when (viewType) {
            TYPE_HOLDER1 -> {
                val view1 = LayoutInflater.from(parent.context).inflate(R.layout.adapter_color, parent, false)
                return Holder1(view1)
            }
            TYPE_HOLDER2 -> {
                val view2 = LayoutInflater.from(parent.context).inflate(R.layout.adapter_color2, parent, false)
                return Holder2(view2)
            }
            TYPE_HOLDER3 -> {
                val view3 = LayoutInflater.from(parent.context).inflate(R.layout.adapter_color3, parent, false)
                return Holder3(view3)
            }
        }
        return null
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val color = ContextCompat.getColor(context, items[position].value)
        when (getItemViewType(position)) {
            TYPE_HOLDER1 -> {
                val holder1 = holder as Holder1
                holder1.colorView.setBackgroundColor(color)
            }
            TYPE_HOLDER2 -> {
                val holder2 = holder as Holder2
                holder2.colorView.setBackgroundColor(color)
                holder2.colorView2.setBackgroundColor(color)
            }
            TYPE_HOLDER3 -> {
                val holder3 = holder as Holder3
                holder3.colorView.setBackgroundColor(color)
                holder3.colorView2.setBackgroundColor(color)
                holder3.colorView3.setBackgroundColor(color)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    companion object {
        private const val TYPE_HOLDER1 = 1
        private const val TYPE_HOLDER2 = 2
        private const val TYPE_HOLDER3 = 3
    }

    class Holder1 constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var colorView: View = itemView.findViewById(R.id.color)
    }

    class Holder2 constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var colorView: View = itemView.findViewById(R.id.color)
        internal var colorView2: View = itemView.findViewById(R.id.color2)
    }

    class Holder3 constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var colorView: View = itemView.findViewById(R.id.color)
        internal var colorView2: View = itemView.findViewById(R.id.color2)
        internal var colorView3: View = itemView.findViewById(R.id.color3)
    }
}