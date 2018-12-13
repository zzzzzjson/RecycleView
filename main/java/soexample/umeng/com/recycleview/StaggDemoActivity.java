package soexample.umeng.com.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.recycleview.adapter.BeautyAdapter;
import soexample.umeng.com.recycleview.bean.BeautyBean;

public class StaggDemoActivity extends AppCompatActivity {
    private List<BeautyBean> mList = new ArrayList<>();
    private int[] mImage = {R.drawable.a, R.drawable.b, R.drawable.c};
    private RecyclerView Stagg_Recy;
    private BeautyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stagg_demo);
        initView();
        initData();
        adapter = new BeautyAdapter(mList, this);
         Stagg_Recy.setAdapter(adapter);
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add(new BeautyBean("啦啦啦"+i,mImage[i%mImage.length]));
            StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
           Stagg_Recy.setLayoutManager(staggeredGridLayoutManager);
           Stagg_Recy.setItemAnimator(new DefaultItemAnimator());
        }
    }

    private void initView() {
        Stagg_Recy = (RecyclerView) findViewById(R.id.Stagg_Recy);

    }
}
