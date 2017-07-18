package tech.hyperdev.scorekeeper.activities;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity{

    int score1 = 0, score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerOne, new ScoreFragment().newInstance("Team 1",score1))
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerTwo, new ScoreFragment().newInstance("Team 2",score2))
                .commit();
    }
}
