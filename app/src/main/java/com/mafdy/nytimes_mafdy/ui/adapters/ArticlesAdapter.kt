package com.mafdy.nytimes_mafdy.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView
import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Results
import com.mafdy.nytimes_mafdy.R
import com.mafdy.nytimes_mafdy.ui.OnClickArticle
import com.mafdy.nytimes_mafdy.ui.main.MainViewModel
import java.util.*

class ArticlesAdapter : RecyclerView.Adapter<ArticlesAdapter.ArticlesViewHolder?>() {
    private var articles: List<Results> = ArrayList<Results>()
    private var itemClickListener: OnClickArticle<Results>? = null


    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): ArticlesViewHolder {
        return ArticlesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.article_recycler_item, parent, false)
        )
    }

    override fun onBindViewHolder(@NonNull holder: ArticlesViewHolder, position: Int) {
        val article: Results = articles[position]
        holder.tvTitle?.text = article.title
        holder.tvCreatedBy?.text = article.byline
        holder.tvSource?.text = article.source
        holder.tvDate?.text = article.published_date
        holder.image?.setImageURI(article.media.get(0).media_metadata.get(2).url)
    }

    fun setArticles(articles: List<Results>) {
        this.articles = articles
        notifyDataSetChanged()
    }

    fun setItemClickListenr(itemClickListenr : OnClickArticle<Results> ) {
        itemClickListener = itemClickListenr
    }


    override fun getItemCount(): Int {
        return articles.size
    }

    inner class ArticlesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var tvTitle: TextView? = null

        var image: SimpleDraweeView? = null

        var tvCreatedBy: TextView? = null

        var tvSource: TextView? = null

        var tvDate: TextView? = null

        init {

            tvTitle = itemView.findViewById<TextView>(R.id.title)
            image = itemView.findViewById<SimpleDraweeView>(R.id.image)
            tvCreatedBy = itemView.findViewById(R.id.created_by)
            tvSource = itemView.findViewById(R.id.source)
            tvDate = itemView.findViewById(R.id.date)


            itemView.setOnClickListener {

                if (itemClickListener != null) {
                    itemClickListener!!.onItemClick(adapterPosition, articles[adapterPosition])
                }


            }
        }
    }
}



