package com.example.mvc.retrofit;
import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GetdataService {



    @FormUrlEncoded
    @POST("/labforagent")
    Call<ResponseBody> getTestsofLab(@Field("agent_id") String agent_id, @Field("lab_id") String lab_id);





}
