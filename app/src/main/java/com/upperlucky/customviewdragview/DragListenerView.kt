package com.upperlucky.customviewdragview

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.Context
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import kotlinx.android.synthetic.main.view_drag_listener.view.*

/**
 * created by yunKun.wen on 2020/9/12
 * desc: startDragAndDrop  onDragListener
 */
class DragListenerView(context: Context, attrs: AttributeSet?) : ConstraintLayout(context, attrs) {

    private val startDrag = OnLongClickListener { v ->
        ViewCompat.startDragAndDrop(v, null,DragShadowBuilder(v), null, 0)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        avator.setOnLongClickListener(startDrag)
        dragLayout.setOnDragListener(DragListener())
    }

    private inner class DragListener : OnDragListener {

        @SuppressLint("ShowToast")
        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DROP -> {
                    if (v is LinearLayout) {
                        Toast.makeText(context,"拖到这里了",Toast.LENGTH_LONG).show()
                    }
                }
            }
            return true
        }

    }
}