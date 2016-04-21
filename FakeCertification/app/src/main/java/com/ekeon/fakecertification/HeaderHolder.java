package com.ekeon.fakecertification;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class HeaderHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.iv_header_profile) SimpleDraweeView ivHeaderProfile;

  public static HeaderHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.header_holder, null);
    return new HeaderHolder(itemView);
  }

  public HeaderHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
    ivHeaderProfile.setImageURI(Uri.parse("https://cloud.githubusercontent.com/assets/10140360/14703263/00fbfd36-07ea-11e6-8f81-f5204747af34.jpg"));
  }
}
