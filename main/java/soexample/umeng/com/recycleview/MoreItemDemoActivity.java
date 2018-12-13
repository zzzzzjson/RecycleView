package soexample.umeng.com.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.recycleview.adapter.MoreAdapter;
import soexample.umeng.com.recycleview.bean.BeautyBean;

public class MoreItemDemoActivity extends AppCompatActivity {
    private List<BeautyBean> mList = new ArrayList<>();
    private RecyclerView More_Recy;
    private MoreAdapter mAdapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_demo);
        initView();
        initData();
        mAdapter = new MoreAdapter(mList);
        More_Recy.setAdapter(mAdapter);
        mAdapter.setOnItemClick(new MoreAdapter.ItemClick() {
            @Override
            public void setOnItem(View v, int position) {
                Toast.makeText(MoreItemDemoActivity.this, mList.get(position).getName() + "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add(new BeautyBean("啦啦啦"+i,R.drawable.a));
        }
    }

    private void initView() {
        More_Recy = (RecyclerView) findViewById(R.id.More_Recy);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        More_Recy.setLayoutManager(layoutManager);
    }
}
