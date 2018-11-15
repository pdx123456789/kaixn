package com.example.administrator.myapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.myapplication.widget.LoadingDialog;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity<V extends IBaseView, P extends AbstractPresent<V>> extends AppCompatActivity implements IBaseView {

    private P presenter;
    public static List<BaseActivity> activities = new ArrayList<BaseActivity>();
    public static BaseActivity mActivity;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (presenter == null) {
            presenter = createPresenter();
        }
        if (presenter == null) {
            throw new NullPointerException("presenter 不能为空");
        }
        presenter.attchView((V) this);
        //添加当前子activity到这个集合中
        activities.add(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mActivity = this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        mActivity = null;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //接触绑定
        if (presenter != null) {
            presenter.detachView();
        }
        //退出当前activity是将该activity从集合中移除
        activities.remove(this);
    }


    public void exit() {
        //copyOnwriteArralist 允许在遍历中增删操作
        //创建临时集合
        List<BaseActivity> copy = new ArrayList<BaseActivity>(activities);
        for (int i = 0; i < copy.size(); i++) {
            BaseActivity baseActivity = copy.get(i);
            baseActivity.finish();
        }
        //杀死当前进程
        android.os.Process.killProcess(android.os.Process.myPid());

    }


    /**
     * 创建presenter
     *
     * @return 子类自己需要的presenter
     */
    protected abstract P createPresenter();

    /**
     * 获取preseter
     *
     * @return 返回子类创建的presenter
     */
    public P getPresenter() {
        return presenter;
    }

    /**
     * 加载中。。。。
     */
    public  void loading(){
        loadingDialog = new LoadingDialog(this);
        loadingDialog.show();
    };

    /**
     * 加载结束
     */
   public  void loadFinish(){
       loadingDialog.dismiss();
   };


}
