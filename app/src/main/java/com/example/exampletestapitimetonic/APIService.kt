package com.example.exampletestapitimetonic

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface APIService {

    @GET("posts")
    suspend fun  getUserPost():ArrayList<createAppkeyModelResponse>

    /* como obtener datos con query sin url fija
    @GET
    fun getData(@Url url: String, @Query("param1") param1: String, @Query("param2") param2: Int): Call<YourResponseModel>

     */

    @GET
    suspend fun createAppKey(@Url urlBase: String, @Query("req") req: String, @Query("appname") appname: String): Response<createAppkeyModelResponse>

    @GET
    suspend fun createOauthkey(@Url urlBase: String, @Query("req") req: String, @Query("login") login: String, @Query("pwd") pwd: String, @Query("appkey") appkey: String): Response<createOauthkeyModelResponse>

    @GET
    suspend fun createSesskey(@Url urlBase: String, @Query("req") req: String, @Query("o_u") o_u: String, @Query("oauthkey") oauthkey: String): Response<createsSesskeyModelResponse>


}

