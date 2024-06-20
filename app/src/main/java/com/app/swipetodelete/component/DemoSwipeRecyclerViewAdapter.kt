package com.app.swipetodelete.component

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.app.swipetodelete.R

/**
 * A simple recycler view adapter with a OnClick interface
 */
class DemoSwipeRecyclerViewAdapter //------------Constructors------------
    (
    /**
     * The displayed ArrayList (here set in the MainActivity)
     */
    private val items: ArrayList<String>
) : RecyclerView.Adapter<DemoSwipeRecyclerViewAdapter.ViewHolder>() {
    //------------Instance Variables------------
    /**
     * An implementation of the Adapters onClickListener Interface
     * to make clicks on the items possible
     */
    private var onItemClickListener: OnItemClickListener? = null


    //------------Recycler View Adapter------------
    override fun onCreateViewHolder(parent: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_swipe_to_delete, parent, false)
        val articleViewHolder = ViewHolder(view, this.onItemClickListener)
        return articleViewHolder
    }


    override fun onBindViewHolder(articleViewHolder: ViewHolder, position: Int) {
        val currentString = items[position]

        articleViewHolder.textView.text = currentString
    }


    override fun getItemCount(): Int {
        return items.size
    }


    class ViewHolder(itemView: View, listener: OnItemClickListener?) :
        RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.tvItem)

        init {
            itemView.setOnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }
        }
    }


    //------------On Click------------
    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.onItemClickListener = listener
    }


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}
