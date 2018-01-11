package com.bawei.jiaosheng0111.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.jiaosheng0111.R;
import com.bawei.jiaosheng0111.bean.ShowBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adminjs on 2018/1/11.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.IViewholder>{
   private Context context;
   private List<ShowBean.MiaoshaBean.ListBeanX>list;

    public GridAdapter(Context context) {
        this.context = context;
    }
    public void addData(ShowBean bean){
        if(list == null){
            list = new ArrayList<>();
        }
        list.addAll(bean.getMiaosha().getList());
        notifyDataSetChanged();
    }

    @Override
    public IViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.layout_grid, null);
        return new IViewholder(view);
    }

    @Override
    public void onBindViewHolder(IViewholder holder, int position) {
        String[] url = list.get(position).getImages().split("\\|");
        holder.simple.setImageURI(url[0],list.get(position).getImages());
        holder.title_grid.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class IViewholder extends RecyclerView.ViewHolder{

        SimpleDraweeView simple;
        TextView title_grid;
        public IViewholder(View itemView) {
            super(itemView);
            simple = itemView.findViewById(R.id.simple_grid);
            title_grid = itemView.findViewById(R.id.title_grid);
        }
    }
}
