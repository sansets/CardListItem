package com.cardlistitem.cardlistitem.base

import com.google.firebase.firestore.FirebaseFirestore


open class BasePresenter<V: MvpView> : MvpPresenter<V> {

    var mvpView: V? = null
    var db = FirebaseFirestore.getInstance()

    override fun onAttach(mvpView: V?) {
        this.mvpView = mvpView
    }

    override fun onDetach() {
        this.mvpView = null
    }

    override fun getView(): V? {
        return mvpView
    }

}