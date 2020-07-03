package com.example.mvc;

import android.util.Log;

import com.example.mvc.retrofit.GetdataService;
import com.example.mvc.retrofit.OrbocareRetrofit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Presenter implements Contract.Userinteraction {

    private Contract.View view;
    public String TAG = "Presenter";


    public Presenter(Contract.View view) {
        this.view = view;
    }

    @Override
    public void getTests(String userID, String labID) {

        final List<Testmodel> testmodels = new ArrayList<>();

        GetdataService getdataService = OrbocareRetrofit.getRetrofitInstance().create(GetdataService.class);
        getdataService.getTestsofLab(userID,labID).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {

                    if (response.isSuccessful()){

                        JSONObject jsonObject = new JSONObject(response.body().string());
                        boolean status = jsonObject.optBoolean("status");
                        int totalResults = jsonObject.optInt("totalResults");
                        JSONArray resultArray = jsonObject.optJSONArray("result");


                        for (int i=0 ;i<resultArray.length() ;i++){

                            JSONObject jsonObject1 = resultArray.getJSONObject(i);


                            Testmodel testmodel = new Testmodel();

                            testmodel.setTestName(jsonObject1.optString("testName"));
                            testmodel.setTestPrice(jsonObject1.optString("testPrice"));
                            testmodel.setTestuid(jsonObject1.optString("testuid"));
                            testmodel.setType(jsonObject1.optString("type"));

                            testmodels.add(testmodel);

                        }

                        Log.d(TAG, "onResponse: "+testmodels.toString());

                        view.fetchedTestmodel( true, testmodels);

                    }
                    else {

                        view.fetchedTestmodel(false, null);
                    }

                } catch (IOException | JSONException e) {
                    view.fetchedTestmodel(false, null);
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                view.fetchedTestmodel(false, null);

            }
        });

    }
}
