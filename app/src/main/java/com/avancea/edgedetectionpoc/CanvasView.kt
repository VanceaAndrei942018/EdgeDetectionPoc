package com.avancea.edgedetectionpoc

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Canvas
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View


class CanvasView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : View(context, attrs, defStyleAttr) {

    private var image: Bitmap = BitmapFactory.decodeResource(resources, R.drawable.document)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        image = EdgeDetectionComponent.drawDocumentEdges(image)

        EdgeDetectionComponent.draw(canvas, image, width, height)

    }

}