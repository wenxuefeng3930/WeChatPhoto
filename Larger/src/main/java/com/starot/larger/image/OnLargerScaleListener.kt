package com.starot.larger.image

interface OnLargerScaleListener {


    fun onScaleEnd() {}

    fun onScaleStart() {}

    fun onScale(scaleFactor: Float, focusX: Float, focusY: Float) {}

}