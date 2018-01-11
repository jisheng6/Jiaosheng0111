package com.bawei.jiaosheng0111;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bawei.jiaosheng0111.Presenter.ShowPresenter;
import com.bawei.jiaosheng0111.adapter.GridAdapter;
import com.bawei.jiaosheng0111.adapter.ListAdapter;
import com.bawei.jiaosheng0111.bean.ShowBean;
import com.bawei.jiaosheng0111.view.ShowView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ShowView {

    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.re_gtidview)
    RecyclerView reGtidview;
    @BindView(R.id.re_listview)
    RecyclerView reListview;
    private ShowPresenter presenter;
    private GridAdapter gridAdapter;
    private ListAdapter listAdapter;
    private List<ShowBean.DataBean> adt = new ArrayList<>();
    private List<String> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new ShowPresenter(this);
        presenter.get();
        gridAdapter = new GridAdapter(this);
        listAdapter = new ListAdapter(this);
        reGtidview.setLayoutManager(new GridLayoutManager(this,6));
        reListview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        reGtidview.setAdapter(gridAdapter);
        reListview.setAdapter(listAdapter);
        list = new ArrayList<>();
    }

    @Override
    public void success(ShowBean bean) {
         gridAdapter.addData(bean);
         listAdapter.addData(bean);
        adt =  bean.getData();
        for (int i=0;i<adt.size();i++){
            list.add(adt.get(i).getIcon());
        }
        banner.setImageLoader(new GlideImageLoader());
        //设置集合
        banner.setImages(list);
        //banner执行完方法之后调用
        banner.start();
    }

    @Override
    public void failure() {

    }
}
