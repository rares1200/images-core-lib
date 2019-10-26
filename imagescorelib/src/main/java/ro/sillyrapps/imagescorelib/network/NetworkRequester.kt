package ro.sillyrapps.imagescorelib.network

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.IOException

object NetworkRequester {

    const val TAG = "NetworkRequester"

    private var baseUrl: String = ""
    private val mNetworkClient: OkHttpClient = OkHttpClient()

    fun setBaseUrl(url: String) {
        baseUrl = url
    }

    fun makeGetRequest(endpoint: String, params: Map<String, Any>): String {
        var requestUrl = baseUrl + endpoint
        if (params.isNotEmpty()) {
            val queryString = StringBuilder()
            for (key in params.keys) {
                if (queryString.isNotEmpty()) {
                    queryString.append("&")
                }
                queryString.append(key)
                queryString.append("=")
                queryString.append(params[key])
            }
            if (queryString.isNotEmpty()) {
                requestUrl += "?$queryString"
            }
        }
        val request = Request.Builder()
            .url(requestUrl)
            .get()
            .build()
        try {
            Log.d(TAG, "Making request to:$requestUrl")
            val response = mNetworkClient.newCall(request).execute()
            val result = response.body?.string()?:""
            Log.d(TAG, "Request result:$result")
            return result
        } catch (ex: IOException) {
            Log.d(TAG,"Error making request:${ex.message}")
            ex.printStackTrace()
        }
        return ""
    }
}