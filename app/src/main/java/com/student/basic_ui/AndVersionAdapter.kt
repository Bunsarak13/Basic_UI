package com.student.basic_ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

class AndVersionAdapter(val items: Array<AndVersion>) : RecyclerView.Adapter<AndVersionAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {

        override val containerView: View?
            get() = itemView

        fun bindAndVersion(andVersion: AndVersion) {
            with(andVersion) {
                //itemView.andVersionTxt.text = "$name"
                itemView.findViewById<TextView>(R.id.andVersionTxt).text = "$name"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndVersionAdapter.ViewHolder {
        return ViewHolder(parent.inflate(R.layout.item_and_version))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAndVersion(items[position])
    }

    private fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
        return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
    }

    override fun getItemCount(): Int = items.size
}
