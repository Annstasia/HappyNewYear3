package com.example.happynewyear3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    private String TAG_DARK = "dark_theme";
    SharedPreferences sharedPreferences;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = this.getSharedPreferences(TAG_DARK, Context.MODE_PRIVATE);

        boolean dark = sharedPreferences.getBoolean(TAG_DARK, false);
        if (dark){
            setTheme(R.style.DarkTheme);
        }

        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        int it = item.getItemId();
        if (it == R.id.app_bar_switch){
            boolean b = sharedPreferences.getBoolean(TAG_DARK, false);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (b) editor.putBoolean(TAG_DARK, false);
            else editor.putBoolean(TAG_DARK, true);
            editor.apply();
//            startActivity(new Intent(MainActivity.this, MainActivity.class));
//            finish();
            this.recreate();
        }
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
