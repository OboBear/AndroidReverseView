package com.obo.reverseview.layout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.obo.reverseview.R;

public class LayoutReverseActivity extends AppCompatActivity implements View.OnClickListener{

    ReverseLayout reverseLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_reverse);
        reverseLayout = (ReverseLayout) findViewById(R.id.reverse_layout);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.reverse_button: {
                reverseLayout.isReverse = !reverseLayout.isReverse;
                reverseLayout.invalidate();
            }
            break;
        }
    }
}
