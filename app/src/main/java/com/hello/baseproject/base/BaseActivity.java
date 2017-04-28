package com.hello.baseproject.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public abstract class BaseActivity extends AppCompatActivity
{
    private Unbinder bind=null;
    public List<Disposable> disposables=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        //设置布局内容
        setContentView(getLayoutId());
        //初始化黄油刀控件绑定框架
        bind=ButterKnife.bind(this);
        //初始化控件
        initViews(savedInstanceState);
        //初始化ToolBar
        initToolBar();
    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initToolBar();

    public void addSubsribe(Disposable a){
        disposables.add(a);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bind.unbind();
        if(disposables.size()!=0){
            for(Disposable a:disposables){
                a.dispose();
            }
        }
    }
}
