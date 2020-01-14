package ru.rgordeev.graph;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean turn = false;
    private int[][] field = {{9,9,9}, {9,9,9}, {9,9,9}};

    private int isWin(int[][] a) {
        boolean result = false;
        for (int i = 0; i < a.length; i++) {
            if (hasWinner(a[i]))
                return a[i][0];
        }
        return 9;
    }

    private boolean hasWinner(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum == 0 || sum == 3;
    }

    public void clickImage(View view) {
        ImageView imageView = (ImageView) view;
        Integer tag = Integer.valueOf(imageView.getTag().toString());
        int i = (tag - 1) / 3;
        int j = (tag - 1) % 3;
        field[i][j] = turn ? 1 : 0;
        imageView.setImageResource(turn ? R.drawable.red : R.drawable.yellow);
        turn = !turn;
        imageView.animate().rotationBy(3600).setDuration(3000);
        if (isWin(field) != 9) {
            Toast.makeText(this, "Player " + isWin(field) + " won!",Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
