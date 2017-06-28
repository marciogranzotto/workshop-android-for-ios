package com.example.ostanik.workshopapp

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import rx.Observable

/**
 * Created by ostanik on 2017-06-27.
 */
interface GreetingsService {
    @GET("/greetings")
    fun fetchGreetings(): Observable<Greetings>

    @POST("/login")
    fun login(@Body loginUser: UserLogin): Observable<User>
}

class User {
    var name: String = ""
    var job: String = ""
}

class UserLogin (var email: String, var password: String)

class Greetings {
    var greetings: List<String> = listOf()
}
