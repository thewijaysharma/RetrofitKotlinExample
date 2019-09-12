package com.example.kotlinretrofit.model

data class PostResponse(
    val `data`: List<Data>,
    val msg: String, //  all posts 
    val success: Int // 1
) {
    data class Data(
        val Image: List<String>,
        val __v: Int, // 0
        val _id: String, // 5d70165289d80d1d486fd80c
        val attachFile: String,
        val commentCount: String, // 0
        val createdAt: String, // 2019-09-04T19:53:54.412Z
        val finalUrl: String,
        val firstName: String, // Saj
        val fullName: String, // Saj Ace
        val hashtags: List<Hashtag>,
        val isBlocked: Int, // 0
        val isLike: String, // 0
        val isSave: String, // 0
        val lastName: String, // Ace
        val rate: String, // 5
        val ratingCount: String, // 2
        val thumbnail: String, // 1567626834144-image.jpg
        val title: String, // #bmw #m3 #wheelspin #donut 
        val type: String, // 2
        val urlDescription: String,
        val urlImage: String,
        val urlSiteName: String,
        val urlTitle: String,
        val userId: String, // 5b7ded88363eea7d2c87cfba
        val userPic: String, // 1534979463897-image.jpg
        val userShare: List<String>,
        val video: String // 1567626832120-video.mp4
    ) {
        data class Hashtag(
            val _id: String, // 5d70165289d80d1d486fd80d
            val name: String // donut
        )
    }
}