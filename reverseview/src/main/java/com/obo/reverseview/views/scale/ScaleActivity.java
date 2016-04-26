package com.obo.reverseview.views.scale;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.obo.reverseview.R;

public class ScaleActivity extends AppCompatActivity implements View.OnClickListener {

    View layoutScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);

        layoutScale = findViewById(R.id.layout_scale);
    }

    @Override
    public void onClick(View v) {
        if (layoutScale.getScaleY() == -1) {
            layoutScale.setScaleY(1);
        } else {
            layoutScale.setScaleY(-1);
        }
    }
}
