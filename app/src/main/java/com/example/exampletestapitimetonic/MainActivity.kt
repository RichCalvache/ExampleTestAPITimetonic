package com.example.exampletestapitimetonic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.exampletestapitimetonic.databinding.ActivityMainBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val urlBase = "https://timetonic.com/live/api.php/"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //CREAR UNA INSTANCIA DE RETROFIT
        val retrofit = Retrofit.Builder()
            .baseUrl(urlBase)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        //CREAR UNA INSTANCIA DEL SERVICIO API
        val service = retrofit.create(APIService::class.java)

        //REALIZAR LA SOLICITUD CON RETROFIT
        val req = "createAppkey"
        val appname = "android"
        var appKey : String

        lifecycleScope.launch {

            //SOLICITUD CREATEAPPKEY
            val response = service.createAppKey(urlBase, req, appname)

            if(response.isSuccessful){
                appKey  = "${response.body()?.appkey}"//obtener un valor
                //Toast.makeText(baseContext,"createAppKey:", Toast.LENGTH_LONG).show()
                //println(appKey)
                println(response.body())//muestra todos los valores en consola


                //SOLICITUD  Oauthkey
                val login = "android.developer@timetonic.com"
                val pwd = "Android.developer1"
                val reqOauth = "createOauthkey"
                //var oauthkey : String


                //CREAR UNA INSTANCIA DEL SERVICIO API
                val serviceoauth = retrofit.create(APIService::class.java)

                val responseOauthkey = serviceoauth.createOauthkey(urlBase, reqOauth, login, pwd, appKey)

                if(responseOauthkey.isSuccessful){
                    val oauthkey = "${responseOauthkey.body()?.appkey}"//obtener un valor
                    val o_u = "${responseOauthkey.body()?.o_u}"//obtener un valor
                    //Toast.makeText(baseContext,"createAppKey:", Toast.LENGTH_LONG).show()
                    //println(appKey)
                    println(responseOauthkey.body())//muestra todos los valores en consola


                    // SOLICITUD createSesskey
                    val reqSess = "createSesskey"

                    //CREAR UNA INSTANCIA DEL SERVICIO API
                    val serviceSess = retrofit.create(APIService::class.java)

                    val responseSesskey = serviceSess.createSesskey(urlBase, reqSess, o_u, oauthkey)

                    if(responseSesskey.isSuccessful){
                        println(responseSesskey.body())//muestra todos los valores en consola
                        val sesskey = "${responseSesskey.body()?.appkey}"//obtener un valor
                    }
                    else{ //error
                        Log.e("Error Retrofit!!","${responseSesskey.code()} - ${responseSesskey.message()}")
                    }



                }
                else{ //error
                    Log.e("Error Retrofit!!","${responseOauthkey.code()} - ${responseOauthkey.message()}")
                }
            }
            else{ //error
                Log.e("Error Retrofit!!","${response.code()} - ${response.message()}")
            }

            /*
            //SOLICITUD  Oauthkey
            val login = "android.developer@timetonic.com"
            val pwd = "Android.developer1"
            val reqOauth = "createOauthkey"
            //var oauthkey : String


            //CREAR UNA INSTANCIA DEL SERVICIO API
            val serviceoauth = retrofit.create(APIService::class.java)

            val responseOauthkey = serviceoauth.createOauthkey(urlBase, reqOauth, login, pwd, appKey)

            if(responseOauthkey.isSuccessful){
                val oauthkey = "${responseOauthkey.body()?.appkey}"//obtener un valor
                //Toast.makeText(baseContext,"createAppKey:", Toast.LENGTH_LONG).show()
                //println(appKey)
                println(responseOauthkey.body())//muestra todos los valores en consola
            }
            else{ //error
                Log.e("Error Retrofit!!","${responseOauthkey.code()} - ${responseOauthkey.message()}")
            }*/



        }







        //BUTTON LOGIN
        binding.buttonLogin.setOnClickListener {




        }
    }
}