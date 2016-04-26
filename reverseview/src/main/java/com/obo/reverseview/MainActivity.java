package com.obo.reverseview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.obo.reverseview.views.animate.AnimateReverseActivity;
import com.obo.reverseview.views.layout.LayoutReverseActivity;
import com.obo.reverseview.views.scale.ScaleActivity;
import com.obo.reverseview.views.surfaceView.SurfaceReverseActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView mChooseList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mChooseList = (ListView) findViewById(R.id.list_choose);
        List chooseList = new ArrayList();
        chooseList.add("动画方式翻转");
        chooseList.add("布局重写draw方式翻转");
        chooseList.add("布局scale方式翻转");
        chooseList.add("SurfaceView翻转");
        mChooseList.setAdapter(new ChooseAdapter(this,chooseList));
        mChooseList.setOnItemClickListener(this);
    }

    Class []ReverseActivities = {
            AnimateReverseActivity.class,
            LayoutReverseActivity.class,
            ScaleActivity.class,
            SurfaceReverseActivity.class
    };

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, ReverseActivities[position]);
        startActivity(intent);
    }
}

class ChooseAdapter extends BaseAdapter {
    List mItemList;
    LayoutInflater mLayoutInflater;
    public ChooseAdapter(Context context,List itemList) {
        this.mItemList = itemList;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemViewHolder itemViewHolder;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.item_main_choose,null);
            itemViewHolder = new ItemViewHolder();
            itemViewHolder.textView = (TextView) convertView.findViewById(R.id.text_description);
            convertView.setTag(itemViewHolder);
        } else {
            itemViewHolder = (ItemViewHolder) convertView.getTag();
        }
        itemViewHolder.textView.setText((String)mItemList.get(position));
        return convertView;
    }
}


class ItemViewHolder {
    TextView textView;
}
