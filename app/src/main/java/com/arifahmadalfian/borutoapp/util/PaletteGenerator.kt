package com.arifahmadalfian.borutoapp.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.request.SuccessResult
import com.arifahmadalfian.borutoapp.util.Constants.DARK_VIBRANT
import com.arifahmadalfian.borutoapp.util.Constants.ON_DARK_VIBRANT
import com.arifahmadalfian.borutoapp.util.Constants.VIBRANT

object PaletteGenerator {

    /**
     * Convert Url to Bitmap
     */
    suspend fun convertImageUrlToBitmap(
        imageUrl: String,
        context: Context
    ): Bitmap? {
        val loader = ImageLoader(context = context)
        val request = ImageRequest.Builder(context = context)
            .data(imageUrl)
            .allowHardware(false)
            .build()
        val imageResult = loader.execute(request = request)
        return if (imageResult is SuccessResult) {
            (imageResult.drawable as BitmapDrawable).bitmap
        } else {
            null
        }
    }

    fun extractColorFromBitmap(bitmap: Bitmap): Map<String, String> {
        return mapOf(
            VIBRANT to parseColorSwitch(
                color = Palette.from(bitmap).generate().vibrantSwatch
            ),
            DARK_VIBRANT to parseColorSwitch(
                color = Palette.from(bitmap).generate().darkVibrantSwatch
            ),
            ON_DARK_VIBRANT to parseBodyColor(
                color = Palette.from(bitmap).generate().darkMutedSwatch?.bodyTextColor
            )
        )
    }

    private fun parseColorSwitch(color: Palette.Swatch?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color.rgb)
            "#$parsedColor"
        } else {
            "#000000"
        }
    }

    private fun parseBodyColor(color: Int?): String {
        return if (color != null) {
            val parsedColor = Integer.toHexString(color)
            "#$parsedColor"
        } else {
            "#FFFFFF"
        }
    }
}