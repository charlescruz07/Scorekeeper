package tech.hyperdev.scorekeeper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import tech.hyperdev.scorekeeper.R;
import tech.hyperdev.scorekeeper.fragments.ScoreFragment;

public class MainActivity extends AppCompatActivity{

    int theme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theme = R.style.DAY_MODE;
        replaceFragments(theme);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.whiteTheme:
                theme = R.style.DAY_MODE;
                replaceFragments(theme);
                break;
            case R.id.darkTheme:
                theme = R.style.NIGHT_MODE;
                replaceFragments(theme);
                break;
        }
        return true;
    }

    public void replaceFragments(int theme){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerOne, new ScoreFragment().newInstance("Team 1",theme))
                .commit();

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.containerTwo, new ScoreFragment().newInstance("Team 2",theme))
                .commit();
    }
}
