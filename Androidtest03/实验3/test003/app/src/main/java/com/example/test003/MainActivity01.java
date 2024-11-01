package com.example.test003;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity01 extends AppCompatActivity {

    private ListView listView;
    private Button selectButton;
    private String selectedAnimal = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        listView = findViewById(R.id.listView);
        selectButton = findViewById(R.id.selectButton);
        List<HashMap<String, String>> animalList = new ArrayList<>();
        animalList.add(new HashMap<String, String>() {{
            put("name", "Lion");
            put("image", "lion");
        }});
        animalList.add(new HashMap<String, String>() {{
            put("name", "Tiger");
            put("image", "tiger");
        }});
        animalList.add(new HashMap<String, String>() {{
            put("name", "Monkey");
            put("image", "monkey");
        }});
        animalList.add(new HashMap<String, String>() {{
            put("name", "Dog");
            put("image", "dog");
        }});
        animalList.add(new HashMap<String, String>() {{
            put("name", "Cat");
            put("image", "cat");
        }});
        animalList.add(new HashMap<String, String>() {{
            put("name", "Elephant");
            put("image", "elephant");
        }});

        // 适配器
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                animalList,
                R.layout.list_item01, // 使用自定义的布局文件
                new String[]{"name", "image"},
                new int[]{R.id.textView, R.id.imageView} // 对应布局文件中的TextView和ImageView
        ) {
            @SuppressLint("DiscouragedApi")
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                ImageView imageView = view.findViewById(R.id.imageView);
                HashMap<String, String> animal = (HashMap<String, String>) getItem(position);
                String imageName = animal.get("image");
                imageView.setImageResource(getResources().getIdentifier(imageName, "drawable", getPackageName()));
                return view;
            }
        };

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            HashMap<String, String> animal = (HashMap<String, String>) parent.getItemAtPosition(position);
            selectedAnimal = animal.get("name");
            selectButton.setText(selectedAnimal);
        });
    }
}