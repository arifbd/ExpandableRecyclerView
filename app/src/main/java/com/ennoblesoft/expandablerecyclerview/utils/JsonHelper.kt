package com.ennoblesoft.expandablerecyclerview.utils

import android.content.Context
import android.util.Log
import com.ennoblesoft.expandablerecyclerview.models.NewspaperModel
import org.json.JSONObject
import com.google.gson.Gson


open class JsonHelper(private var context: Context) {
    private var newspaperList: MutableList<NewspaperModel>? = null

    open fun getNewspaperData(): List<NewspaperModel>? {
        if (newspaperList == null)
            newspaperList = ArrayList()

        try {
            val jsonObject = JSONObject(getJSONFromAssets("fake_data.json"))
            val jsonArray = jsonObject.getJSONArray("news_papers")
            val k = jsonArray.length()

            for (i in 0 until k) {
                val tempJsonObject = jsonArray.getJSONObject(i).toString()
                val gson = Gson()
                val newsPaper = gson.fromJson<NewspaperModel>(tempJsonObject, NewspaperModel::class.java)
                newspaperList?.add(newsPaper)
            }
            return newspaperList
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }

    private fun getJSONFromAssets(fileName: String): String? {
        val json: String
        try {
            val inputStream = context.assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
        return json
    }
}