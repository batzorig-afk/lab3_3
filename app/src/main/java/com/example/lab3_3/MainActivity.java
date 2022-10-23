package com.example.lab3_3;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdapter extends BaseAdapter {
        Context context;
        Integer[] posterID = {R.drawable.bird1, R.drawable.bird2,
                R.drawable.bird3, R.drawable.bird4, R.drawable.bird5, R.drawable.bird6, R.drawable.bird7, R.drawable.bird8, R.drawable.bird9, R.drawable.bird10, R.drawable.bird11, R.drawable.bird12};
        public MyGridAdapter(Context c) {
            context = c;
        }
        @Override
        public int getCount() {
            return posterID.length;
        }
        @Override
        public Object getItem(int arg0) {
            return null;
        }
        @Override
        public long getItemId(int arg0) {
            return 0;
        }
        public View getView(int position, View arg1, ViewGroup arg2) {
            final ImageView imView = new ImageView(context);
            imView.setLayoutParams(new GridView.LayoutParams(100, 150));
            imView.setScaleType(ImageView.ScaleType.FIT_CENTER); imView.setPadding(5, 5, 5, 5); imView.setImageResource(posterID[position]);
            final int pos = position; imView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View)
                            View.inflate(MainActivity.this, R.layout.dialog, null); AlertDialog.Builder dbl = new
                            AlertDialog.Builder(MainActivity.this); ImageView ivPoster = (ImageView)
                            dialogView.findViewById(R.id.ivPost); ivPoster.setImageResource(posterID[pos]);
                    dbl.setTitle("Томруулсан зураг"); dbl.setIcon(R.drawable.bird2); dbl.setView(dialogView); dbl.setNegativeButton("Хаах", null); dbl.show();
                } });
            return imView;
        }
    }
}