package ro.sillyrapps.imagescorelib.download

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import java.util.*

object ImageDownloadManager {

    fun downloadFromUrl(activity: Activity, folderName: String, url: String) {
        val path = "${Environment.getExternalStorageDirectory()}/$folderName"
        val downloadManager = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri = Uri.parse(url)
        val request = DownloadManager.Request(uri)
        val cal = Calendar.getInstance()
        val name = "image_${cal.timeInMillis}.jpg"
        request.setDestinationInExternalPublicDir(path, name)
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        downloadManager.enqueue(request)
    }

}