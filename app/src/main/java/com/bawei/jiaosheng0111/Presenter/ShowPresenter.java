package com.bawei.jiaosheng0111.Presenter;

import com.bawei.jiaosheng0111.bean.ShowBean;
import com.bawei.jiaosheng0111.model.ShowModel;
import com.bawei.jiaosheng0111.view.ShowView;

/**
 * Created by Adminjs on 2018/1/11.
 */

public class ShowPresenter {
    private ShowView view;
    private ShowModel model;

    public ShowPresenter(ShowView view) {
        this.view = view;
        this.model = new ShowModel();
    }
    public void get(){
        model.getData(new ShowModel.ModelCallBack() {
            @Override
            public void success(ShowBean bean) {
                if (view != null){
                    view.success(bean);
                }
            }
        });
    }
}
