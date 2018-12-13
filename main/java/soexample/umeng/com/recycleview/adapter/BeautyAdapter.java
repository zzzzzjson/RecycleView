package soexample.umeng.com.recycleview.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;
import java.util.Random;

import soexample.umeng.com.recycleview.R;
import soexample.umeng.com.recycleview.bean.BeautyBean;

public class BeautyAdapter extends RecyclerView.Adapter<BeautyAdapter.ViewHolder>{
   private List<BeautyBean> mList;
   private Context context;

    public BeautyAdapter(List<BeautyBean> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       //如果用到瀑布流 因为需要改里面高度，所以要把ViewGroup放进去 所以就用LayoutInflate就好
        View view = LayoutInflater.from(context).inflate(R.layout.beauty_item, viewGroup,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BeautyBean bean = mList.get(i);
        ViewGroup.LayoutParams params = viewHolder.itemView.getLayoutParams();
        int height = new Random().nextInt(300) + 300;
        params.height=height;
        viewHolder.itemView.setLayoutParams(params);
        viewHolder.mImage.setImageResource(bean.getImage());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private  ImageView mImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.Beauty_Image);
        }
    }
}
