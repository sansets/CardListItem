package com.cardlistitem.cardlistitem.mvp.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.cardlistitem.cardlistitem.R
import com.cardlistitem.cardlistitem.model.Post
import com.cardlistitem.cardlistitem.ui.MvpActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MvpActivity<MainPresenter>(), MainMvpView {

    internal lateinit var mainAdapter: MainAdapter
    internal lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainAdapter = MainAdapter(applicationContext)
        layoutManager = LinearLayoutManager(applicationContext)
        recycler_view.layoutManager = layoutManager
        recycler_view.adapter = mainAdapter

        mvpPresenter.loadPost()
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter(this)
    }

    override fun displayPostList(posts: ArrayList<Post>?) {
        mainAdapter.setPostList(posts)
    }
}
