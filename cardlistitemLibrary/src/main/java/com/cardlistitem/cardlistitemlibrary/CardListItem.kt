package com.cardlistitem.cardlistitemlibrary

import android.content.Context
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.v7.widget.CardView
import android.support.v7.widget.Toolbar
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class CardListItem @JvmOverloads constructor(
        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    val headerToolbar by lazy { findViewById<Toolbar>(R.id.toolbar) }
    val headerImageView by lazy { findViewById<CircleImageView>(R.id.header_image) }
    val headerTitleTextView by lazy { findViewById<TextView>(R.id.header_title) }
    val contentImageView by lazy { findViewById<ImageView>(R.id.content_image) }
    val contentTitleTextview by lazy { findViewById<TextView>(R.id.content_title) }
    val contentShortDescriptionTextView by lazy { findViewById<TextView>(R.id.content_short_description) }
    val contentTextLayout by lazy { findViewById<LinearLayout>(R.id.content_text_layout) }
    val timestamptTextView by lazy { findViewById<TextView>(R.id.timestamp) }

    @DrawableRes
    var headerImageSrc: Int? = null
        set(value) {
            field = value
            if (value != 0) headerImageView.setImageResource(value!!)
        }

    var headerTitle: String? = null
        set(value) {
            field = value
            headerTitleTextView.text = value
            headerToolbar.visibility = if (value != null) View.VISIBLE else View.GONE
        }

    @DrawableRes
    var contentImageSrc: Int? = null
        set(value) {
            field = value
            if (value != 0) contentImageView.setImageResource(value!!)
        }

    @StringRes
    var contentTitle: String? = null
        set(value) {
            field = value
            contentTitleTextview.text = value
            contentTitleTextview.visibility = if (value != null) View.VISIBLE else View.GONE
        }

    @StringRes
    var contentImageVisibility: Int? = null
        set(value) {
            field = value
            if (value == 1) contentImageView.visibility = View.GONE
        }

    @StringRes
    var contentShortDescription: String? = null
        set(value) {
            field = value
            contentShortDescriptionTextView.text = value
            contentShortDescriptionTextView.visibility = if (value != null) View.VISIBLE else View.GONE
        }

    @StringRes
    var timestamp: String? = null
        set(value) {
            field = value
            timestamptTextView.text = value
            timestamptTextView.visibility = if (value != null) View.VISIBLE else View.GONE
        }

    init {
        View.inflate(context, R.layout.cardlistitem, this)

        context.obtainStyledAttributes(attrs, R.styleable.CardListItem).apply {
            headerImageSrc = getResourceId(R.styleable.CardListItem_headerImageSrc, 0)
            headerTitle = getString(R.styleable.CardListItem_headerTitle)
            contentImageSrc = getResourceId(R.styleable.CardListItem_contentImageSrc, 0)
            contentImageVisibility = getInt(R.styleable.CardListItem_contentImageVisibility, 0)
            contentTitle = getString(R.styleable.CardListItem_contentTitle)
            contentShortDescription = getString(R.styleable.CardListItem_contentShortDescription)
            timestamp = getString(R.styleable.CardListItem_timestampt)
            setContentTextLayout(headerTitle, contentShortDescription, timestamp)
        }
    }

    private fun setContentTextLayout(contentTitle: String?, contentShortDescription: String?, timestamp: String?) {
        if (contentTitle == null && contentShortDescription == null && timestamp == null) {
            contentTextLayout.visibility = View.GONE
        }
    }

}