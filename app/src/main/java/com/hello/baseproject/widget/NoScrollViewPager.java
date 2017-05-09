package com.hello.baseproject.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.hello.baseproject.R;


/**
 * 重写Viewpager解决点击tab去除滑动动画效果的问题
 */
public class NoScrollViewPager extends ViewPager {
  private boolean isCanScroll;

  public NoScrollViewPager(Context context) {

    super(context);
  }


  public NoScrollViewPager(Context context, AttributeSet attrs) {
    super(context, attrs);
    TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.NoScrollViewPager);
    /*获取布局中设置的属性*/
    isCanScroll = a.getBoolean(R.styleable.NoScrollViewPager_isCanScroll, false);
    a.recycle();
  }


  @Override
  public void scrollTo(int x, int y) {
      super.scrollTo(x, y);
  }


  @Override
  public void setCurrentItem(int item, boolean smoothScroll) {

    super.setCurrentItem(item, smoothScroll);
  }


  @Override
  public void setCurrentItem(int item) {

    super.setCurrentItem(item, false);
  }

  @Override
  public boolean onTouchEvent(MotionEvent ev) {
    if(isCanScroll) {
      return super.onTouchEvent(ev);
    }else{
      return false;
    }
  }

  @Override
  public boolean onInterceptTouchEvent(MotionEvent ev) {
    if(isCanScroll) {
      return super.onInterceptTouchEvent(ev);
    }else{
      return false;
    }
  }


  public void setCanScroll(boolean isCanScroll){
    this.isCanScroll=isCanScroll;
  }

}
