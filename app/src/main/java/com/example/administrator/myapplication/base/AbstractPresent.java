package com.example.administrator.myapplication.base;

public abstract class AbstractPresent<V extends IBaseView> {
    private V mView;

    /**
     * 绑定v层
     * @param view
     */
    public void attchView(V view){
        this.mView=view;
    }


    /**
     * 解除绑定v层
     */
    public void detachView(){
        mView=null;
    }

    public V getmView(){
        return mView;
    }
}
