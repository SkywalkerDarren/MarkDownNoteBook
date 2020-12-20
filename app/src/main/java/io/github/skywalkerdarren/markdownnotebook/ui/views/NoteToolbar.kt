package io.github.skywalkerdarren.markdownnotebook.ui.views

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import io.github.skywalkerdarren.markdownnotebook.R
import io.github.skywalkerdarren.markdownnotebook.databinding.ToolbarCommonBinding
import io.github.skywalkerdarren.markdownnotebook.utils.color
import io.github.skywalkerdarren.markdownnotebook.utils.use

class NoteToolbar(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
    Toolbar(context, attrs, defStyleAttr) {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    private var binding: ToolbarCommonBinding =
        ToolbarCommonBinding.inflate(LayoutInflater.from(context), this, true)

    private var textBack: String? = null
        set(value) {
            field = value
            binding.tvBack.text = value
            binding.tvBack.isVisible = value != null
        }
    private var textTitle: String? = null
        set(value) {
            field = value
            binding.tvTitle.text = value
            binding.tvTitle.isVisible = value != null
        }
    private var textMenu: String? = null
        set(value) {
            field = value
            binding.tvMenu.text = value
            binding.tvMenu.isVisible = value != null
        }

    var backColor: Int = R.color.gray_100.color()
        set(value) {
            field = value
            binding.ivBack.setColorFilter(value, PorterDuff.Mode.SRC_IN)
            binding.tvBack.setTextColor(value)
        }
    var titleColor: Int = R.color.gray_100.color()
        set(value) {
            field = value
            binding.tvTitle.setTextColor(value)
        }
    var menuColor: Int = R.color.gray_100.color()
        set(value) {
            field = value
            binding.ivMenu.setColorFilter(value, PorterDuff.Mode.SRC_IN)
            binding.tvMenu.setTextColor(value)
        }
    var subMenuColor: Int = R.color.gray_100.color()
        set(value) {
            field = value
            binding.ivSubMenu.setColorFilter(value, PorterDuff.Mode.SRC_IN)

        }

    private var iconBack: Drawable? = null
        set(value) {
            field = value
            binding.ivBack.setImageDrawable(value)
            binding.ivBack.isVisible = value != null
        }
    private var iconMenu: Drawable? = null
        set(value) {
            field = value
            binding.ivMenu.setImageDrawable(value)
            binding.ivMenu.isVisible = value != null
        }
    private var iconSubMenu: Drawable? = null
        set(value) {
            field = value
            binding.ivSubMenu.setImageDrawable(value)
            binding.ivSubMenu.isVisible = value != null
        }

    init {
        context.obtainStyledAttributes(attrs, R.styleable.NoteToolbar).use {
            textBack = getString(R.styleable.NoteToolbar_text_back)
            textTitle = getString(R.styleable.NoteToolbar_text_title)
            textMenu = getString(R.styleable.NoteToolbar_text_menu)

            backColor = getColor(R.styleable.NoteToolbar_color_back, backColor)
            titleColor = getColor(R.styleable.NoteToolbar_color_title, titleColor)
            menuColor = getColor(R.styleable.NoteToolbar_color_menu, menuColor)
            subMenuColor = getColor(R.styleable.NoteToolbar_color_sub_menu, menuColor)

            iconBack = getDrawable(R.styleable.NoteToolbar_icon_back)
            iconMenu = getDrawable(R.styleable.NoteToolbar_icon_menu)
            iconSubMenu = getDrawable(R.styleable.NoteToolbar_icon_sub_menu)
        }
    }

    fun setBack(text: String?) {
        textBack = text
    }

    fun setBack(drawable: Drawable?) {
        iconBack = drawable
    }

    fun setTitle(text: String?) {
        textTitle = text
    }

    fun setMenu(text: String?) {
        textMenu = text
    }

    fun setMenu(drawable: Drawable?) {
        iconMenu = drawable
    }

    fun setSubMenu(drawable: Drawable?) {
        iconSubMenu = drawable
    }

    fun setBackClickListener(block: () -> Unit) {
        binding.tvBack.setOnClickListener { block() }
        binding.ivBack.setOnClickListener { block() }
    }

    fun setMenuClickListener(block: () -> Unit) {
        binding.tvMenu.setOnClickListener { block() }
        binding.ivMenu.setOnClickListener { block() }
    }

    fun setTitleClickListener(block: () -> Unit) {
        binding.tvTitle.setOnClickListener { block() }
    }

    fun setSubMenuClickListener(block: () -> Unit) {
        binding.ivSubMenu.setOnClickListener { block() }
    }
}