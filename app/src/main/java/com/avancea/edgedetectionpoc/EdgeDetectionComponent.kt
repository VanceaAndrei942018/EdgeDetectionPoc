package com.avancea.edgedetectionpoc

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect

object EdgeDetectionComponent {

    fun draw(
        canvas: Canvas?,
        bitmap: Bitmap,
        width: Int,
        height: Int
    ) {
        val paint = Paint()
        val rect = Rect(0, 0, width, height)

        canvas?.drawBitmap(bitmap, null, rect, paint)
    }

    fun drawDocumentEdges(image: Bitmap): Bitmap {
        TODO("Not yet implemented")
    }


}