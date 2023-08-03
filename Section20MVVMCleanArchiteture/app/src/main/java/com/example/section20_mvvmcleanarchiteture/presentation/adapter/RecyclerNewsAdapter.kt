package com.example.section20_mvvmcleanarchiteture.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.section20_mvvmcleanarchiteture.R
import com.example.section20_mvvmcleanarchiteture.data.model.Article
import com.example.section20_mvvmcleanarchiteture.databinding.NewsListItemBinding

class RecyclerNewsAdapter: RecyclerView.Adapter<RecyclerNewsAdapter.ViewHolder>() {

    //DiffUtil
    private val callback = object : DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = NewsListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = differ.currentList.get(position)
        holder.bind(article)
    }

    override fun getItemCount(): Int  = differ.currentList.size





    private var onItemClickListener : ((Article) -> Unit)? = null

    fun setOnItemClickListener(listener: (Article) -> Unit){
        onItemClickListener = listener
    }


    inner class ViewHolder(private val itemBinding: NewsListItemBinding): RecyclerView.ViewHolder(itemBinding.root){

        fun bind(article: Article){
            itemBinding.tvTitle.text = article.title
            itemBinding.tvDescription.text = article.description
            itemBinding.tvSource.text = article.source?.name
            itemBinding.tvPublishedAt.text = article.publishedAt
            Glide.with(itemBinding.root.context).load(article.urlToImage).into(itemBinding.ivArticleImage)

            itemBinding.root.setOnClickListener{
                onItemClickListener?.let {
                    it(article)
                }
            }
        }
    }
}