package com.ekeon.fakecertification.fakeinsta.holder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.ekeon.fakecertification.R;

import butterknife.ButterKnife;

/**
 * Created by Ekeon on 2016. 4. 21..
 */
public class ActionbarHolder extends RecyclerView.ViewHolder{

  public static ActionbarHolder newInstance(Context context) {
    View itemView = LayoutInflater.from(context).inflate(R.layout.actionbar_holder, null);
    return new ActionbarHolder(itemView);
  }

  public ActionbarHolder(View itemView) {
    super(itemView);
    ButterKnife.bind(this, itemView);
  }
}
