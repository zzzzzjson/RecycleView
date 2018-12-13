package soexample.umeng.com.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> mList = new ArrayList<>();
    private Button Linear_Btn;
    private Button Grid_Btn;
    private Button Stagger_Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        Linear_Btn = (Button) findViewById(R.id.Linear_Btn);
        Grid_Btn = (Button) findViewById(R.id.Grid_Btn);
        Stagger_Btn = (Button) findViewById(R.id.Stagger_Btn);

        Linear_Btn.setOnClickListener(this);
        Grid_Btn.setOnClickListener(this);
        Stagger_Btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Linear_Btn:
                startActivity(new Intent(MainActivity.this, LinearDemoActivity.class));
                break;
            case R.id.Grid_Btn:
                startActivity(new Intent(MainActivity.this,MoreItemDemoActivity.class));
                break;
            case R.id.Stagger_Btn:
                startActivity(new Intent(MainActivity.this, StaggDemoActivity.class));
                break;
        }
    }
    //    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
//    private void initViews() {
//        mRecy = findViewById(R.id.Recy);
//        //得让这个RecyclerView显示样式
//        GridLayoutManager grid = new GridLayoutManager(this, 3);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        DividerGridItemDecoration divider = new DividerGridItemDecoration(this);
//        mRecy.addItemDecoration(divider);
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
//        dividerItemDecoration.setDrawable(getDrawable(R.drawable.recycler_divider));
//        mRecy.addItemDecoration(dividerItemDecoration);
//        mRecy.setLayoutManager(grid);
//    }
}
