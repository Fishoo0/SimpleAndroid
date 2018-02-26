package com.acmes.acmes;

import com.acmes.acmes.mode.bean.DCategories;
import com.acmes.acmes.mode.bean.DUser;
import com.acmes.acmes.mode.request.CategoriesRequest;
import com.acmes.acmes.mode.request.LoginRequest;
import com.acmes.acmes.mode.request.LogoutRequest;
import com.acmes.acmes.mode.request.RegisterRequest;
import com.acmes.acmes.mode.response.AcmesResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by fishyu on 2018/1/2.
 */

public interface AcmesAPI {

    String BASE_URL = "http://45.77.179.207:5000";

    @POST("register")
    Observable<AcmesResponse<DUser>> register(@Body RegisterRequest loginRequest);

    @POST("login")
    Observable<AcmesResponse<DUser>> login(@Body LoginRequest loginRequest);

    @POST("logout")
    Observable<AcmesResponse> logout(@Body LogoutRequest request);

    @POST("categories")
    Observable<DCategories> categories(@Body CategoriesRequest request);

}