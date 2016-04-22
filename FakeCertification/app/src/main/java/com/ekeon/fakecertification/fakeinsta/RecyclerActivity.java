package com.ekeon.fakecertification.fakeinsta;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.ekeon.fakecertification.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class RecyclerActivity extends AppCompatActivity {

  @Bind(R.id.rv_main) RecyclerView rvMain;

  RecyclerAdapter recyclerAdapter;

  private Dialog dialog;

  private String nickname;
  private String content;
  private String hashtag;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.recycler_main);
    ButterKnife.bind(this);

    recyclerAdapter = new RecyclerAdapter();
    String filepath = getIntent().getStringExtra("filepath");
    recyclerAdapter.setFilePath(filepath);

    rvMain.setLayoutManager(new LinearLayoutManager(this));
    rvMain.setAdapter(recyclerAdapter);

    dialog = createDialog();
    dialog.show();
  }

  private AlertDialog createDialog() {
    View view = getLayoutInflater().inflate(R.layout.text_dialog, null);
    final EditText etNickname = (EditText)view.findViewById(R.id.et_dialog_nickname);
    final EditText etContent = (EditText)view.findViewById(R.id.et_dialog_content);
    final EditText etHashtag = (EditText)view.findViewById(R.id.et_dialog_hashtag);

    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setTitle("information");
    builder.setView(view);
    builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        nickname = etNickname.getText().toString();
        content = etContent.getText().toString();
        hashtag = etHashtag.getText().toString();
        recyclerAdapter.setMainInfo(nickname, content, hashtag);
        recyclerAdapter.notifyHeaderReaction();
        dialog.dismiss();
      }
    });

    builder.setNegativeButton("취소", new DialogInterface.OnClickListener() {
      @Override
      public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
      }
    });

    return builder.create();
  }
}
