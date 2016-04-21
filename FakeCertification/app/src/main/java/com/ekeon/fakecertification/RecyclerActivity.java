package com.ekeon.fakecertification;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class RecyclerActivity extends AppCompatActivity {

  @Bind(R.id.rv_main) RecyclerView rvMain;

  RecyclerAdapter recyclerAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recycler_main);
    ButterKnife.bind(this);

    recyclerAdapter = new RecyclerAdapter();
    String filepath = getIntent().getStringExtra("filepath");
    recyclerAdapter.setBitmap(filepath);

    rvMain.setLayoutManager(new LinearLayoutManager(this));
    rvMain.setAdapter(recyclerAdapter);
  }
}
