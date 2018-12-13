package soexample.umeng.com.recycleview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import soexample.umeng.com.recycleview.adapter.MyAdapter;
import soexample.umeng.com.recycleview.view.DividerGridItemDecoration;

public class LinearDemoActivity extends AppCompatActivity {
    private List<String> mList = new ArrayList<>();
    private RecyclerView More_Recy;
    private MyAdapter myAdapter;
    private RecyclerView Recy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_demo);
        initView();
        myAdapter = new MyAdapter(mList);
        Recy.setAdapter(myAdapter);
        initData();
        myAdapter.setOnClickListener(new MyAdapter.ItemClick() {
            @Override
            public void setOnItemClick(View view, int i) {
                Toast.makeText(LinearDemoActivity.this, mList.get(i), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mList.add("啦啦啦" + i);
        }
        myAdapter.notifyDataSetChanged();
    }

    private void initView() {
        Recy = (RecyclerView) findViewById(R.id.Recy);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        DividerGridItemDecoration divider = new DividerGridItemDecoration(this);
        Recy.addItemDecoration(divider);
        Recy.setLayoutManager(layoutManager);

    }
}
