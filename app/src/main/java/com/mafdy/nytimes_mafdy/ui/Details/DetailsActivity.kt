package com.mafdy.nytimes_mafdy.ui.Details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.mafdy.nytimes_mafdy.Model.Retrofit.ResponseMappings.Results
import com.mafdy.nytimes_mafdy.databinding.ActivityArticlesDetailsBinding

class DetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityArticlesDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArticlesDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var articleJson = intent.getStringExtra("Article")
        val g = Gson()
        var article = g.fromJson<Results>(articleJson, Results::class.java)

        binding.image.setImageURI(article.media.get(0).media_metadata.get(2).url)
        binding.titleDes.setText(article.title)
        binding.descriptionDes.setText(article.abstract)
        binding.createdByDes.setText(article.byline)
        binding.sourceDes.setText(article.source)


    }
}