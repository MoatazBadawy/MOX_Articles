package com.moataz.mox.utils.helper

object HttpRoutes {
    private const val BASE_URL = "https://api.rss2json.com/v1/api.json"
    private const val KEY = "?api_key=b7fnpiy39m1ntewj93105d5ukhpmifvmnqufyksq"

    const val TECH = "$BASE_URL?rss_url=https://www.theverge.com/rss/full.xml$KEY"
    const val PROGRAMMING = "$BASE_URL?rss_url=https://betterprogramming.pub/feed$KEY"
    const val ANDROID = "$BASE_URL?rss_url=https://medium.com/feed/tag/androiddev$KEY"
    const val KOTLIN = "$BASE_URL?rss_url=https://medium.com/feed/tag/kotlin$KEY"
    const val UX = "$BASE_URL?rss_url=https://uxplanet.org/feed$KEY"
}