package com.ekeon.fakecertification;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class RecyclerAdapter extends RecyclerView.Adapter {

  private final int TYPE_HEADER = 0;
  private final int TYPE_IMAGE = 1;
  private final int TYPE_REACTION = 2;

  private String filepath = "";

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    Context context = parent.getContext();

    switch (viewType) {
      case TYPE_HEADER:
        viewHolder = HeaderHolder.newInstance(context);
        break;
      case TYPE_IMAGE:
        viewHolder = ImageHolder.newInstance(context);
        break;
      case TYPE_REACTION:
        viewHolder = ReactionHolder.newInstance(context);
    }
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof HeaderHolder) {
    }
    if (holder instanceof ImageHolder) {
      if (position == 1) {
        ((ImageHolder) holder).setImage(filepath);
        Log.d("TAG", "IMAGEHOLDER");
      }
    }
    if (holder instanceof ReactionHolder) {
    }
  }

  public void setBitmap(String filepath) {
    this.filepath = filepath;
  }

  @Override
  public int getItemCount() {
    return 3;
  }

  @Override
  public int getItemViewType(int position) {
    if (position == 0) {
      return TYPE_HEADER;
    }

    if (position == 1) {
      return TYPE_IMAGE;
    }

    if (position == 2) {
      return TYPE_REACTION;
    }
    return super.getItemViewType(position);
  }
}
