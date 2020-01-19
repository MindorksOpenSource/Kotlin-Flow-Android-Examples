package com.mindorks.coroutinesbasics.model


import com.google.gson.annotations.SerializedName

data class APIResponse(
    @SerializedName("per_page")
    val perPage: Int = 0,
    @SerializedName("total")
    val total: Int = 0,
    @SerializedName("data")
    val data: ArrayList<DataItem>?,
    @SerializedName("page")
    val page: Int = 0,
    @SerializedName("total_pages")
    val totalPages: Int = 0
)


data class DataItem(
    @SerializedName("last_name")
    val lastName: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("avatar")
    val avatar: String = "",
    @SerializedName("first_name")
    val firstName: String = "",
    @SerializedName("email")
    val email: String = ""
)


