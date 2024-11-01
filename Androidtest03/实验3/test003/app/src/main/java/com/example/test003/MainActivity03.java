package com.example.test003;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class MainActivity03 extends AppCompatActivity {

    private TextView testTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        testTextView = findViewById(R.id.test_text_view);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main03, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_font_size_small) {
            testTextView.setTextSize(10);
        } else if (id == R.id.action_font_size_medium) {
            testTextView.setTextSize(16);
        } else if (id == R.id.action_font_size_large) {
            testTextView.setTextSize(20);
        } else if (id == R.id.action_font_color_red) {
            testTextView.setTextColor(getResources().getColor(R.color.red));
        } else if (id == R.id.action_font_color_black) {
            testTextView.setTextColor(getResources().getColor(R.color.black));
        } else if (id == R.id.action_normal) {
            Toast.makeText(this, "普通菜单项被点击", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}