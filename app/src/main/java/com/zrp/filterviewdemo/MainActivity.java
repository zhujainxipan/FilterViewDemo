package com.zrp.filterviewdemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.zrp.filterviewdemo.filter.ExpandTabView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ExpandTabView expandTabView;
    private TextView mTvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandTabView = (ExpandTabView) findViewById(R.id.expand_tabview);
        mTvShow = (TextView) findViewById(R.id.tv_show);

        initFilterView();

    }

    private void initFilterView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        fragments.add(fragment1);
        fragments.add(fragment2);

        CommonFragmentAdapter mCommonFragmentAdapter = new CommonFragmentAdapter(getSupportFragmentManager(), fragments);
        expandTabView.setFilterAdapter(mCommonFragmentAdapter);

        ArrayList<String> nameList = new ArrayList<>();
        nameList.add("性别");
        nameList.add("地点");
        expandTabView.setNameList(nameList);

        fragment1.setSelectListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvShow.setText("111111111111111");
                expandTabView.setTabTxt("1111111");
            }
        });
    }


}

