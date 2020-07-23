package com.avancea.edgedetectionpoc

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView

internal class CustomOverlay @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttribute: Int = 0
) : AppCompatImageView(context, attributeSet, defStyleAttribute) {

    private var paint = Paint()
    private var mRatioWidth = 0
    private var mRatioHeight = 0
    private var count = 50


    init {
        paint.color = Color.RED
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (count == 250) count = 50
        canvas.drawRect(
            width / 2f - count,
            height / 2f - count,
            width / 2f + count,
            height / 2f + count,
            paint
        )
        count++
    }

    fun setAspectRatio(width: Int, height: Int) {
        require(!(width < 0 || height < 0)) { "Size cannot be negative." }
        mRatioWidth = width
        mRatioHeight = height
        requestLayout()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val width: Int = MeasureSpec.getSize(widthMeasureSpec)
        val height: Int = MeasureSpec.getSize(heightMeasureSpec)
        if (0 == mRatioWidth || 0 == mRatioHeight) {
            setMeasuredDimension(width, height)
        } else {
            if (width < height * mRatioWidth / mRatioHeight) {
                setMeasuredDimension(width, width * mRatioHeight / mRatioWidth)
            } else {
                setMeasuredDimension(height * mRatioWidth / mRatioHeight, height)
            }
        }
    }

    fun processFrame(frame: Bitmap?) {
        setImageBitmap(frame)
        requestLayout()
    }
}