package com.cardlistitem.cardlistitem.base

interface MvpPresenter<V: MvpView> {

    fun onAttach(mvpView: V?)

    fun getView(): V?

    fun onDetach()

}