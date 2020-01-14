package ru.rgordeev.graph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private boolean fade = false;

    public void fade(View view) {
        ImageView imageView = (ImageView) view;
        imageView.animate()
                .alpha(fade ? 1 : 0)
                .rotationBy(1800)
                .translationXBy(1000)
                .setDuration(3000);
        fade = !fade;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.animate().translationX(-1000);
    }
}
