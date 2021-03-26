package com.mafdy.nytimes_mafdy.ui


interface OnClickArticle<T> {
    fun onItemClick(position: Int, model: T)
}