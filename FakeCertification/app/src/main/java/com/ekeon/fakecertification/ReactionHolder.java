package com.ekeon.fakecertification;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class ReactionHolder extends RecyclerView.ViewHolder {

  public static ReactionHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.reaction_holder, null);
    return new ReactionHolder(itemView);
  }

  public ReactionHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
