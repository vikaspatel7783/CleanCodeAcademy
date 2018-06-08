package com.cleancodeacademy.mobile.network;

import com.cleancodeacademy.mobile.network.model.Note;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ServiceApi {

    @POST("/posts")
        //@FormUrlEncoded
    Call<Note> saveNote(/*@Field("title") String title,
                        @Field("body") String body,
                        @Field("userId") long userId*/
            @Body Note note);

}
