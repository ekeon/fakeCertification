package com.ekeon.fakecertification.fakeinsta.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.ekeon.fakecertification.R;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class ImageHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.iv_main_imageView) ImageView ivMainImageView;

  public static ImageHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.image_holder, null);
    return new ImageHolder(itemView);
  }

  public ImageHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);

    DisplayMetrics displayMetrics = itemView.getContext().getResources().getDisplayMetrics();
    int width = displayMetrics.widthPixels;

    ivMainImageView.getLayoutParams().width = width;
    ivMainImageView.getLayoutParams().height = width;

    ivMainImageView.setRotation(90);
  }

  public void setImage(String filepath) {
      ivMainImageView.setRotation(90);
      ivMainImageView.setImageURI(Uri.fromFile(new File(filepath)));
  }
}
