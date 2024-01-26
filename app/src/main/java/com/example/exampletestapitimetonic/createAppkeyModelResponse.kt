package com.example.exampletestapitimetonic

import com.google.gson.annotations.SerializedName

data class createAppkeyModelResponse (

    @SerializedName("status") var status: String,
    @SerializedName("appkey") var appkey: String,
    @SerializedName("createdVNB") var createdVNB: String,
    @SerializedName("req") var req: String
)