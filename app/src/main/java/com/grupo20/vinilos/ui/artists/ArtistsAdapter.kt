package com.grupo20.vinilos.ui.artists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.grupo20.vinilos.modelos.Artist
import com.grupo20.vinilos.R
import com.grupo20.vinilos.databinding.ArtistItemBinding

class ArtistsAdapter : RecyclerView.Adapter<ArtistsAdapter.CollectorViewHolder>(){

    var artists :List<Artist> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectorViewHolder {
        val withDataBinding: ArtistItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            CollectorViewHolder.LAYOUT,
            parent,
            false)
        return CollectorViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: CollectorViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.artist = artists[position]
        }
        /*holder.viewDataBinding.root.setOnClickListener {
            val action = ArtistFragmentDirections.actionArtistFragmentToArtistFragment()
            // Navigate using that action
            holder.viewDataBinding.root.findNavController().navigate(action)
        }*/
    }

    override fun getItemCount(): Int {
        return artists.size
    }


    class CollectorViewHolder(val viewDataBinding: ArtistItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.artist_item
        }
    }


}