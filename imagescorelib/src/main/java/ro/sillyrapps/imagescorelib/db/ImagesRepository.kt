package ro.sillyrapps.imagescorelib.db

import android.content.Context

object ImagesRepository {

    var pageSize = 25

    fun saveImage(ctx: Context, imageData: ImageData): Long {
        val db = AppDatabase.getInstance(ctx)
        return db?.imagesDao()?.saveImage(imageData)?:0
    }

    fun listImages(ctx: Context, page: Int): List<ImageData> {
        val db = AppDatabase.getInstance(ctx)
        val offset = page * pageSize
        return db?.imagesDao()?.listImages(pageSize, offset)?: mutableListOf()
    }

    fun deleteImage(ctx: Context, picId: Long): Int {
        return AppDatabase.getInstance(ctx)?.imagesDao()?.deleteImage(picId)?:0
    }

    fun checkImageSaved(ctx: Context, picId: Long): Boolean {
        val result = AppDatabase.getInstance(ctx)?.imagesDao()?.checkExist(picId)?:0
        return result > 0
    }
}