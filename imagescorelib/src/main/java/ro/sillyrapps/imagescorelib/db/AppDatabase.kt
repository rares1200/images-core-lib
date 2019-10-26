package ro.sillyrapps.imagescorelib.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageData::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DEFAULT_ID = 0
        private var INSTANCE: AppDatabase? = null

        fun getInstance(ctx: Context?): AppDatabase? {
            if (INSTANCE == null) {
                ctx?.let {
                    INSTANCE = Room.databaseBuilder(
                        it,
                        AppDatabase::class.java,
                        "images.db"
                    ).fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }

    abstract fun imagesDao(): ImagesDao

}