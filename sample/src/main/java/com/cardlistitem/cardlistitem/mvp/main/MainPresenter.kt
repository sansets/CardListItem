package com.cardlistitem.cardlistitem.mvp.main

import android.content.ContentValues.TAG
import android.util.Log
import com.cardlistitem.cardlistitem.base.BasePresenter
import com.cardlistitem.cardlistitem.model.Post
import com.cardlistitem.cardlistitem.model.User


class MainPresenter(mainMvpView: MainMvpView) : BasePresenter<MainMvpView>() {

    init {
        onAttach(mainMvpView)
    }

    fun loadPost() {
        db.collection("posts")
                .get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val posts = ArrayList<Post>()

                        for (document in task.result) {
                            val post = document.toObject(Post::class.java)
                            post.postId = document.id

                            db.collection("users")
                                    .document(post.userId!!)
                                    .get()
                                    .addOnCompleteListener { taskUser ->
                                        if (taskUser.isSuccessful) {
                                            val user = taskUser.result.toObject(User::class.java)
                                            user?.userId = taskUser.result.id

                                            post.user = user

                                            posts.add(post)
                                            getView()?.displayPostList(posts)
                                        }
                                    }
                        }
                    } else {
                        Log.w(TAG, "Error getting documents.", task.exception)
                    }
                }
    }

}