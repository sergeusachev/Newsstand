package com.example.serge.newsstand.repository

import com.example.serge.newsstand.api.NewsApi
import com.example.serge.newsstand.request.CategoriesEnum
import com.example.serge.newsstand.request.CountryEnum
import com.example.serge.newsstand.response.NewsResponse
import io.reactivex.Single
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsApi: NewsApi) : INewsRepository {
    override fun getTopHeadlinesNews(pageNumber: Int): Single<NewsResponse> {
        return newsApi.newsTopHeadlinesObservable(
                CountryEnum.RU.countryCode,
                CategoriesEnum.GENERAL.categoryName,
                null,
                null,
                null,
                pageNumber)
    }

    override fun getTopHeadlinesNews(country: String?, category: String?, sources: String?,
                                     query: String?, pageSize: Int?, page: Int?): Single<NewsResponse> {
        return newsApi.newsTopHeadlinesObservable(country, category, sources, query, pageSize, page)

    }

}

interface INewsRepository {
    fun getTopHeadlinesNews(country: String? = null, category: String? = null, sources: String? = null,
                            query: String? = null, pageSize: Int? = null, page: Int? = null): Single<NewsResponse>

    fun getTopHeadlinesNews(pageNumber: Int): Single<NewsResponse>
}