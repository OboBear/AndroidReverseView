package com.obo.reverseview.views.animate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;

import com.obo.reverseview.R;

/**
 * Created by obo on 15/12/6.
 */

public class AnimateReverseActivity extends AppCompatActivity implements View.OnClickListener {

    boolean isReverse = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.reverse_button:
                View layout = findViewById(R.id.reverse_layout);
                if (!isReverse) {
                    Animation animation = new Rotate3dAnimation(layout.getWidth() / 2, layout.getHeight() / 2);
                    animation.setFillAfter(true);
                    layout.startAnimation(animation);
                }
                else {
                    layout.clearAnimation();
                }
                isReverse = !isReverse;
                break;
        }
    }
}