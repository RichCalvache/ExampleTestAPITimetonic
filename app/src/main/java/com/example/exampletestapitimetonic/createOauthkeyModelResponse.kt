package com.example.exampletestapitimetonic

import com.google.gson.annotations.SerializedName

data class createOauthkeyModelResponse (

    @SerializedName("status") var status: String,
    @SerializedName("oauthkey") var appkey: String,
    @SerializedName("id") var id: Int,
    @SerializedName("o_u") var o_u: String,
    @SerializedName("createdVNB") var createdVNB: String,
    @SerializedName("req") var req: String
)