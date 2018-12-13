package soexample.umeng.com.recycleview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import soexample.umeng.com.recycleview.R;
import soexample.umeng.com.recycleview.bean.BeautyBean;

public class MoreAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
   private List<BeautyBean> mList;
   private final int ONE_ITEM=1;
   private final int TWO_ITEM=2;
    public MoreAdapter(List<BeautyBean> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=null;
        RecyclerView.ViewHolder holder=null;
        switch (i){
            case ONE_ITEM:
                 view = View.inflate(viewGroup.getContext(), R.layout.recy_item_one, null);
                 holder = new OneHolder(view);
                break;
            case TWO_ITEM:
                view = View.inflate(viewGroup.getContext(), R.layout.recy_item_two, null);
                holder = new TwoHolder(view);
                break;
        }
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        BeautyBean bean = mList.get(i);
        //判断前一个参数是否是后一个参数的一个实例
        if (viewHolder instanceof OneHolder) {
            ((OneHolder) viewHolder).mName.setText(bean.getName());
            // ((OneHolder) viewHolder).itemView.setTag(i);
        } else {
            ((TwoHolder) viewHolder).mImage.setImageResource(bean.getImage());
            //  ((TwoHolder) viewHolder).itemView.setTag(i);
        }
        viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 1) {
            return ONE_ITEM;
        } else {
            return TWO_ITEM;
        }
    }

    class OneHolder extends RecyclerView.ViewHolder{
        private  TextView mName;

        public OneHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.One_Text);
        }
    }
    class TwoHolder extends RecyclerView.ViewHolder{
        private ImageView mImage;

        public TwoHolder(@NonNull View itemView) {
            super(itemView);
            mImage = itemView.findViewById(R.id.Two_Image);
        }
    }

    public interface ItemClick {
        void setOnItem(View v, int position);
    }

    private ItemClick itemClick;

    public void setOnItemClick(ItemClick itemClick) {
        this.itemClick = itemClick;
    }

    @Override
    public void onClick(View v) {
        if (itemClick != null) {
            itemClick.setOnItem(v, (int) v.getTag());
        }
    }
}
