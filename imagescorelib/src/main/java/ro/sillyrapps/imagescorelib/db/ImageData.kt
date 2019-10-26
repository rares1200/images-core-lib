package ro.sillyrapps.imagescorelib.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "images")
class ImageData(@PrimaryKey(autoGenerate = true) var id: Long,
                @ColumnInfo(name = "pic_id") var picId: Long,
                @ColumnInfo(name = "author") var author: String,
                @ColumnInfo(name = "url") var url: String)