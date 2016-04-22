package com.ekeon.fakecertification.fakeinsta.holder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.ekeon.fakecertification.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 21..
 */
public class DummyImageHolder extends RecyclerView.ViewHolder {

  private static final int POSITION_FIRST_IMAGE = 2;
  private static final int POSITION_FIRST_DUMMYIMAGE = 5;
  private static final int POSITION_SECOND_DUMMYIMAGE = 8;
  private static final int POSITION_THIRD_DUMMYIMAGE = 11;


  @Bind(R.id.iv_dummy_image) SimpleDraweeView ivDummyImage;

  public static DummyImageHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.dummy_image_holder, null);
    return new DummyImageHolder(itemView);
  }

  public DummyImageHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);

    DisplayMetrics displayMetrics = itemView.getContext().getResources().getDisplayMetrics();
    int width = displayMetrics.widthPixels;
    ivDummyImage.getLayoutParams().width = width;
    ivDummyImage.getLayoutParams().height = width;
  }

  public void setPosition(int position) {
    Log.d("TAG","PSOSADF : " + position);
    switch (position) {
      case POSITION_FIRST_DUMMYIMAGE:
        ivDummyImage.setImageURI(Uri.parse("https://scontent.cdninstagram.com/t51.2885-15/sh0.08/e35/p750x750/12394124_665563540251290_668329095_n.jpg?ig_cache_key=MTIxMjc1OTM1MjYwNzM4Mjg0OQ%3D%3D.2"));
        break;
      case POSITION_SECOND_DUMMYIMAGE:
        ivDummyImage.setImageURI(Uri.parse("https://scontent.cdninstagram.com/t51.2885-15/e35/12976669_1590880761239624_1582924808_n.jpg?ig_cache_key=MTIzMjk5Mjg3NTM3OTc2OTYwNg%3D%3D.2"));
        break;
      case POSITION_THIRD_DUMMYIMAGE:
        ivDummyImage.setImageURI(Uri.parse("https://scontent.cdninstagram.com/t51.2885-15/s750x750/sh0.08/e35/12934868_619912671498323_134354042_n.jpg?ig_cache_key=MTIyMDMxNzY0MDM4OTUxMjc2OQ%3D%3D.2"));
        break;

    }
  }
}
