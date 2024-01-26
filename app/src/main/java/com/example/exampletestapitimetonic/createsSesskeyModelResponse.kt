package com.example.exampletestapitimetonic

import com.google.gson.annotations.SerializedName

data class createsSesskeyModelResponse (

    @SerializedName("status") var status: String,
    @SerializedName("sesskey") var appkey: String,
    @SerializedName("id") var id: Int,
    @SerializedName("createdVNB") var createdVNB: String,
    @SerializedName("req") var req: String
)