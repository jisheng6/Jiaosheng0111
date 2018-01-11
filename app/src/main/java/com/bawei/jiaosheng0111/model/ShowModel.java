package com.bawei.jiaosheng0111.model;

import com.bawei.jiaosheng0111.MyApp;
import com.bawei.jiaosheng0111.bean.ShowBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Adminjs on 2018/1/11.
 */

public class ShowModel {
    public void getData(final ModelCallBack callBack){
        MyApp.api.getShow()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowBean>() {
                    @Override
                    public void accept(ShowBean bean) throws Exception {
                      callBack.success(bean);
                    }
                });
    }

    public interface ModelCallBack {
        public void success(ShowBean bean);
    }
}
