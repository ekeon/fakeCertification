package com.ekeon.fakecertification.fakeinsta.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ekeon.fakecertification.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class ReactionHolder extends RecyclerView.ViewHolder {

  private static final int POSITION_FIST_REACTION = 1;
  private static final int POSITION_FIRST_DUMMY_REACTION = 3;
  private static final int POSITION_SECOND_DUMMY_REACTION = 5;
  private static final int POSITION_THIRD_DUMMY_REACTION = 7;

  @Bind(R.id.tv_reaction_nickname) TextView tvReactionNickname;
  @Bind(R.id.tv_content) TextView tvContent;
  @Bind(R.id.tv_hashtag) TextView tvHashTag;


  public static ReactionHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.reaction_holder, null);
    return new ReactionHolder(itemView);
  }

  public ReactionHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }


  public void setPosition(int position, String nickname, String content, String hashtag) {
    Log.d("TAG","sadf" + position);
    switch (position) {
      case POSITION_FIST_REACTION:
        setText("" + nickname,"" + content,"" + hashtag);
        break;
      case POSITION_FIRST_DUMMY_REACTION:
        setText("sh_9513", "!!", "#hi");
        break;
      case POSITION_SECOND_DUMMY_REACTION:
        setText("timmelideo", "And now, pizza.", "#timspizzas #timsfood #merandtimneverstop");
        break;
      case POSITION_THIRD_DUMMY_REACTION:
        setText("jin_a_nana)", "밀라노~", "#그라치아 #graziakorea #milano");
        break;
    }
  }

  private void setText(String nickname, String content, String hashtag) {
    tvReactionNickname.setText("" + nickname);
    tvContent.setText("" + content);
    tvHashTag.setText("" + hashtag);
  }
}
