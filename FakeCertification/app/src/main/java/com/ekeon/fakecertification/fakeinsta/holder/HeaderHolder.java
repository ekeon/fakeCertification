package com.ekeon.fakecertification.fakeinsta.holder;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ekeon.fakecertification.R;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class HeaderHolder extends RecyclerView.ViewHolder {

  private static final int POSITION_DEFAULT_HEADERIMAGE = 0;
  private static final int POSITION_FIRST_HEADERIMAGE = 2;
  private static final int POSITION_SECOND_HEADERIMAGE = 4;
  private static final int POSITION_THIRD_HEADERIMAGE = 6;

  @Bind(R.id.iv_header_profile) SimpleDraweeView ivHeaderProfile;
  @Bind(R.id.tv_header_nickname) TextView tvHeaderNickname;
  @Bind(R.id.ll_header) LinearLayout llHeader;

  public static HeaderHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.header_holder, null);
    return new HeaderHolder(itemView);
  }

  public HeaderHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);

    DisplayMetrics displayMetrics = itemView.getContext().getResources().getDisplayMetrics();
    int width = displayMetrics.widthPixels;
    llHeader.getLayoutParams().width = width;
  }

  public void setPosition(int position, String nickname) {
    Log.d("TAG", "headerposition : " + position);
    switch (position) {
      case POSITION_DEFAULT_HEADERIMAGE:
        ivHeaderProfile.setImageURI(Uri.parse("https://cloud.githubusercontent.com/assets/10140360/14703263/00fbfd36-07ea-11e6-8f81-f5204747af34.jpg"));
        tvHeaderNickname.setText("" + nickname);
        break;
      case POSITION_FIRST_HEADERIMAGE:
        ivHeaderProfile.setImageURI(Uri.parse("https://scontent.cdninstagram.com/t51.2885-19/s150x150/12331897_988150171223172_1145285122_a.jpg"));
        tvHeaderNickname.setText("sh_9513");
        break;
      case POSITION_SECOND_HEADERIMAGE:
        ivHeaderProfile.setImageURI(Uri.parse("https://scontent.cdninstagram.com/t51.2885-19/10899340_469450459899982_621101757_a.jpg"));
        tvHeaderNickname.setText("timmelideo");
        break;
      case POSITION_THIRD_HEADERIMAGE:
        ivHeaderProfile.setImageURI(Uri.parse("https://scontent.cdninstagram.com/t51.2885-19/s150x150/11355722_1615956502015543_697785097_a.jpg"));
        tvHeaderNickname.setText("jin_a_nana");
        break;
    }

  }
}
