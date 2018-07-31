package com.cardlistitem.cardlistitem.mvp.main

import com.cardlistitem.cardlistitem.base.MvpView
import com.cardlistitem.cardlistitem.model.Post

interface MainMvpView : MvpView {

    fun displayPostList(posts: ArrayList<Post>?)

}