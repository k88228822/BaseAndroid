package com.hello.baseproject.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.Disposable;

public abstract class BaseFragment extends Fragment
{
    private Unbinder bind=null;
    public List<Disposable> disposables=new ArrayList<>();
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(getLayoutId(), container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {

        super.onViewCreated(view, savedInstanceState);
        bind =ButterKnife.bind(this, view);
        initViews();
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
        if(disposables.size()!=0){
            for(Disposable a:disposables){
                a.dispose();
            }
        }
    }

    public void addSubsribe(Disposable a){
        disposables.add(a);
    }

    public abstract int getLayoutId();

    public abstract void initViews();
}
