package com.bawei.jiaosheng0111;

import com.bawei.jiaosheng0111.bean.ShowBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Adminjs on 2018/1/11.
 */

public interface API {
    //http://120.27.23.105/ad/getAd
    @GET("/ad/getAd")
    Observable<ShowBean> getShow();
}
