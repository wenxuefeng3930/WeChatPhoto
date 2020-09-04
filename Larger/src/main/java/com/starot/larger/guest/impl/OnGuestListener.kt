package com.starot.larger.guest.impl

interface OnGuestListener : OnGuestTapListener, OnGuestDragListener, OnGuestScaleListener {


}


interface OnGuestScaleListener {
    //缩放结束
    fun onScaleStart()

    //缩放手势
    fun onScale(scaleFactor: Float, focusX: Float, focusY: Float)

    //缩放结束
    fun onScaleEnd()
}


interface OnGuestDragListener {
    //移动
    fun onDrag(x: Float, y: Float)

    //开始移动
    fun onDragStart()

    //结束移动
    fun onDragEnd()
}

interface OnGuestTapListener {
    //单点击手势
    fun onSingleTap()

    //长按
    fun onLongPress()

    //双击手势
    fun onDoubleTap()
}