package com.hello.baseproject.fragment;

import android.support.v7.widget.RecyclerView;

import com.hello.baseproject.R;
import com.hello.baseproject.base.BaseFragment;
import com.hello.baseproject.cell.BannerCell;
import com.hello.baseproject.entity.TestResult;
import com.hello.baseproject.net.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomeFragment extends BaseFragment{
    @BindView(R.id.home_recyclerview)
    RecyclerView recyclerView;

    private List<BannerCell> bannerCells=new ArrayList<>();

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initViews() {
        initData();
    }

    private void initData() {

        new RetrofitHelper().getParamTestResult("1")
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .subscribe(new Observer<TestResult>() {
                                @Override
                                public void onSubscribe(Disposable d) {
                                    addSubsribe(d);
                                }

                                @Override
                                public void onNext(TestResult value) {
                                    System.out.println("获取到的是："+value+"");
                                }

                                @Override
                                public void onError(Throwable e) {
                                    System.out.println("error:"+e);
                                }

                                @Override
                                public void onComplete() {
                                    System.out.println("完成");
                                }
                            });
    }

}
