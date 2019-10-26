package ro.sillyrapps.imagescorelib.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveImage(image: ImageData): Long

    @Query("SELECT  * FROM images LIMIT :limit OFFSET :offset")
    fun listImages(limit: Int, offset: Int): List<ImageData>

    @Query("SELECT COUNT(pic_id) FROM images WHERE pic_id = :picId")
    fun checkExist(picId: Long): Int

    @Query("DELETE FROM images WHERE pic_id = :picId")
    fun deleteImage(picId: Long): Int

}