package com.hello.baseproject.net;

import com.hello.baseproject.application.MyApplication;
import com.hello.baseproject.entity.BannerItem;
import com.hello.baseproject.entity.TblUser;
import com.hello.baseproject.entity.TestResult;
import com.hello.baseproject.utils.ConstantUtil;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Query;

/**
 * Created by wangzhen on 2016/12/19.
 */

public class RetrofitHelper implements ApiService{
    public static final String BASE_URL="http://192.168.0.10:8080/";

    public static final String TEST_URL="http://retrofit.devwiki.net/";

    private static OkHttpClient mOkHttpClient;

    static
    {
        initOkHttpClient();
    }

    /**
     * 初始化OKHttpClient
     */
    private static void initOkHttpClient()
    {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null)
        {
            synchronized (RetrofitHelper.class)
            {
                if (mOkHttpClient == null)
                {
//                    //设置Http缓存
                    Cache cache = new Cache(new File(MyApplication.getApplication()
                            .getCacheDir(), "HttpCache"), 1024 * 1024 * 10);
                    mOkHttpClient = new OkHttpClient.Builder()
                            .cache(cache)
                            .addInterceptor(new LoggingInterceptor())
                            .addNetworkInterceptor(new CacheInterceptor())
//                            .addNetworkInterceptor(new StethoInterceptor())
//                            .addInterceptor(interceptor)
                            .retryOnConnectionFailure(true)
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(20, TimeUnit.SECONDS)
                            .readTimeout(20, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    public  static ApiService getApi (String baseuRL){

        Retrofit.Builder builder = new Retrofit.Builder();
        System.out.printf("创建apiService");
        return  builder.client(mOkHttpClient)
                .baseUrl(baseuRL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class);
    }

    @Override
    public Observable<TblUser> getUserInfo(@Query("method") String method, @Query("userId") String userId) {
        return getApi(BASE_URL).getUserInfo(method,userId);
    }

    @Override
    public Observable<TestResult> getResult() {
        return getApi(TEST_URL).getResult();
    }

    @Override
    public Observable<TestResult> getParamTestResult(@Query("id") String id) {
        System.out.println("执行getParamTestResult");
        return getApi(TEST_URL).getParamTestResult(id);
    }

    @Override
    public Observable<List<BannerItem>> getBannerDetail(@Query("type") int type) {
        return getApi(ConstantUtil.BASIC_URL).getBannerDetail(type);
    }


}
