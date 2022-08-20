package com.moataz.mox.data.model

data class ArticleResponse(
    val feed: Feed?,
    val items: List<Item>?,
    val status: String?
)