package com.cardlistitem.cardlistitem.model

data class Post (
        var postId: String? = null,
        var userId: String? = null,
        var user: User? = null,
        var contentImage: String? = null,
        var contentTitle: String? = null,
        var contentDescription: String? = null,
        var timeUploaded: String? = null
)