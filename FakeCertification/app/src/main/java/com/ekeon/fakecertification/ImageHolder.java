package com.ekeon.fakecertification;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class ImageHolder extends RecyclerView.ViewHolder {

  @Bind(R.id.iv_main_imageView) ImageView ivMainImageView;

  private int width;
  private int height;

  public static ImageHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.image_holder, null);
    return new ImageHolder(itemView);
  }

  public ImageHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);

    DisplayMetrics displayMetrics = itemView.getContext().getResources().getDisplayMetrics();
    width = displayMetrics.widthPixels;
    height = displayMetrics.heightPixels;
  }

  public void setImage(String filepath) {
    try{
      ivMainImageView.setRotation(90);
      Bitmap bm = BitmapFactory.decodeFile(filepath);
      Bitmap resizebm = Bitmap.createScaledBitmap(bm, width, width, true);
      ivMainImageView.setImageBitmap(resizebm);
      ivMainImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
}
