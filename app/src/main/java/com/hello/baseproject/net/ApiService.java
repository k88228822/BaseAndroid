package com.hello.baseproject.net;


import com.hello.baseproject.entity.BannerItem;
import com.hello.baseproject.entity.TblUser;
import com.hello.baseproject.entity.TestResult;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by wangzhen on 2016/12/19.
 */

public interface ApiService {

    @GET("/mywebproject/user/UserServlet")
    Observable<TblUser> getUserInfo(@Query("method") String method, @Query("userId") String userId);

    @GET("/ip")
    Observable<TestResult> getResult();

    @GET("param")
    Observable<TestResult> getParamTestResult(@Query("id") String id);

    @GET("course_api/banner")
    Observable<List<BannerItem>> getBannerDetail(@Query("type") int type);

}
