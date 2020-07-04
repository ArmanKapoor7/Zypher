package com.example.zypher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int seekvalue,i;
    TextView textView;
    ImageButton b,b2,b3,b4,b5,b6,b7;
    Button b8,b9,b10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textView8);
        String text = " ";
        try {
            InputStream is = getAssets().open("2states.txt");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            text = new String(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
        textView.setText(text);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ImageButton button = findViewById(R.id.imageButton13);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotosecond = new Intent();
                gotosecond.setClass(MainActivity.this,SecondActivity.class);
                startActivity(gotosecond);
                finish();
                overridePendingTransition(R.anim.slideinleft,R.anim.slideinleft);
            }

        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "You clicked Search", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.settings) {
            Toast.makeText(getApplicationContext(), "You clicked Settings", Toast.LENGTH_SHORT).show();
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this, R.style.BottomSheet);

            View bottomSheet = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheet, (LinearLayout) findViewById(R.id.bottomsheetcont));
            bottomSheetDialog.setContentView(bottomSheet);
            bottomSheetDialog.show();

            Spinner spinner = bottomSheet.findViewById(R.id.spinner);

            List<String> list = new ArrayList<>();
            list.add("Arial");
            list.add("Bahnschrift");
            list.add("Calibri");
            list.add("Dotum");
            list.add("Elephant");
            list.add("Forte");
            list.add("Gabriola");
            list.add("Harrington");
            list.add("Javanese");
            list.add("Kristen ITC");

            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_spinner_item, list);
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(arrayAdapter);

            textView = bottomSheet.findViewById(R.id.textView3);
            SeekBar seekBar = bottomSheet.findViewById(R.id.seekBar);


            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                    seekvalue = progress;
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                    textView.setText(textView.getText().toString());
                    textView.setTextSize(seekvalue);
                }
            });


            b = bottomSheet.findViewById(R.id.imageButton);
            b.setOnClickListener(this);

            b2 = bottomSheet.findViewById(R.id.imageButton2);
            b2.setOnClickListener(this);

            b3 = bottomSheet.findViewById(R.id.imageButton3);
            b3.setOnClickListener(this);

            b4 = bottomSheet.findViewById(R.id.imageButton4);
            b4.setOnClickListener(this);

            b5 = bottomSheet.findViewById(R.id.imageButton5);
            b5.setOnClickListener(this);

            b6 = bottomSheet.findViewById(R.id.imageButton6);
            b6.setOnClickListener(this);

            b7 = bottomSheet.findViewById(R.id.imageButton7);
            b7.setOnClickListener(this);



        } else if (id == R.id.bookmark) {
            Toast.makeText(getApplicationContext(), "You clicked Bookmark", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                b.setImageResource(R.drawable.ic_format_align_left_black_24dp);
                b2.setImageResource(R.drawable.ic_format_align_right);
                b3.setImageResource(R.drawable.ic_format_align_justify);
                b4.setImageResource(R.drawable.ic_format_align_center);
                break;
            case R.id.imageButton2:
                b.setImageResource(R.drawable.ic_format_align_left);
                b2.setImageResource(R.drawable.ic_format_align_right_black_24dp);
                b3.setImageResource(R.drawable.ic_format_align_justify);
                b4.setImageResource(R.drawable.ic_format_align_center);
                break;
            case R.id.imageButton3:
                b.setImageResource(R.drawable.ic_format_align_left);
                b2.setImageResource(R.drawable.ic_format_align_right);
                b3.setImageResource(R.drawable.ic_format_align_justify_black_24dp);
                b4.setImageResource(R.drawable.ic_format_align_center);
                break;
            case R.id.imageButton4:
                b.setImageResource(R.drawable.ic_format_align_left);
                b2.setImageResource(R.drawable.ic_format_align_right);
                b3.setImageResource(R.drawable.ic_format_align_justify);
                b4.setImageResource(R.drawable.ic_format_align_center_black_24dp);
                break;
            case R.id.imageButton5:
                b5.setImageResource(R.drawable.ic_menu_24dp);
                b6.setImageResource(R.drawable.ic_menu_black_32dp);
                b7.setImageResource(R.drawable.ic_menu_black_40dp);
                break;
            case R.id.imageButton6:
                b5.setImageResource(R.drawable.ic_menu_black_24dp);
                b6.setImageResource(R.drawable.ic_menu_32dp);
                b7.setImageResource(R.drawable.ic_menu_black_40dp);
                break;
            case R.id.imageButton7:
                b5.setImageResource(R.drawable.ic_menu_black_24dp);
                b6.setImageResource(R.drawable.ic_menu_black_32dp);
                b7.setImageResource(R.drawable.ic_menu_40dp);
                break;


        }

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {


    }
}
