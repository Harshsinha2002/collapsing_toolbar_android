package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class MainActivity extends AppCompatActivity {

    String health = "Health";
    ImageView image;
    int char_count = 0;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinator_layout);
        AppBarLayout appBarLayout = findViewById(R.id.app_bar_layout);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        image  = findViewById(R.id.image);

        causedelay(health);
    }

    private void causedelay(String health)
    {
        if(char_count <= health.length())
        {
            String fetchedTxt = health.substring(0,char_count);
            collapsingToolbarLayout.setTitle(fetchedTxt);
            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    char_count++;
                    causedelay(health);
                }
            }, 300);
        }

        else
        {
            imageAnimation();
        }
    }

    private void imageAnimation()
    {
        image.setImageDrawable(getDrawable(R.drawable.female_doc_img));
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_animation);
        image.startAnimation(animation);
    }
}