package com.mafdy.nytimes_mafdy.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Results
import com.mafdy.nytimes_mafdy.databinding.ActivityMainBinding
import com.mafdy.nytimes_mafdy.ui.Details.DetailsActivity
import com.mafdy.nytimes_mafdy.ui.OnClickArticle
import com.mafdy.nytimes_mafdy.ui.adapters.ArticlesAdapter

class MainActivity : AppCompatActivity() , OnClickArticle<Results>  {

    lateinit var context: Context

    lateinit var mainActivityViewModel: MainViewModel

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        context = this@MainActivity

        mainActivityViewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        mainActivityViewModel.getMostPopular()!!.observe(this, Observer { serviceMostPopular ->

            var s1 = serviceMostPopular.copyright

            var listResult = serviceMostPopular.results

            setupRecyclerViewArticles(listResult)


        })


    }

    fun setupRecyclerViewArticles(listResult: List<Results>)
    {
        var adapter = ArticlesAdapter()
        adapter.setArticles(listResult)
        adapter.setItemClickListenr(MainActivity@this)

        binding.recyclerview1.layoutManager = LinearLayoutManager(context)
        binding.recyclerview1.adapter = adapter
        adapter.notifyDataSetChanged()


    }

    override fun onItemClick(position: Int, model: Results) {
        var i = Intent(context, DetailsActivity::class.java)

        val g = Gson()
        i.putExtra("Article", g.toJson(model))

        context.startActivity(i)

    }
}