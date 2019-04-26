package com.ennoblesoft.expandablerecyclerview.models

import com.google.gson.GsonBuilder
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewspaperModel(
        @SerializedName("name")
        var paperName: String? = null,
        @SerializedName("headlines")
        var paperHeadlines: List<HeadlinesModel>? = null,
        @SerializedName("is_expanded")
        var isExpanded: Boolean? = false
) : Serializable {
    override
    fun toString(): String {
        return GsonBuilder().serializeNulls().create().toJson(this)
    }
}