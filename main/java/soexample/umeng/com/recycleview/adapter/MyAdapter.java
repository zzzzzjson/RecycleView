package soexample.umeng.com.recycleview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import soexample.umeng.com.recycleview.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener{
    private List<String> mList;

    public MyAdapter(List<String> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(viewGroup.getContext(), R.layout.recy_item, null);
        ViewHolder holder = new ViewHolder(view);
        view.setOnClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
      viewHolder.mName.setText(mList.get(i));
      viewHolder.itemView.setTag(i);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.recy_name);
        }
    }
    public interface ItemClick{
        void setOnItemClick(View view,int i);
    }
    private ItemClick itemClick;
    public void setOnClickListener(ItemClick itemClick){
        this.itemClick=itemClick;
    }
    @Override
    public void onClick(View v) {
     if (itemClick!=null){
         itemClick.setOnItemClick(v, (int) v.getTag());
     }
    }
}
