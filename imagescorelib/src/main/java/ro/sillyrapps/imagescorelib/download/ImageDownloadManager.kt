package ro.sillyrapps.imagescorelib.download

import android.app.Activity
import android.app.DownloadManager
import android.content.Context
import android.net.Uri

object ImageDownloadManager {

    fun downloadFromUrl(activity: Activity, url: String) {
        val downloadManager = activity.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val uri = Uri.parse(url)
        val request = DownloadManager.Request(uri)
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        downloadManager.enqueue(request)
    }

}