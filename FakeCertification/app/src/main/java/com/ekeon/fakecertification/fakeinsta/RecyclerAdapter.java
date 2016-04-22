package com.ekeon.fakecertification.fakeinsta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ekeon.fakecertification.fakeinsta.holder.ActionbarHolder;
import com.ekeon.fakecertification.fakeinsta.holder.DummyImageHolder;
import com.ekeon.fakecertification.fakeinsta.holder.HeaderHolder;
import com.ekeon.fakecertification.fakeinsta.holder.ImageHolder;
import com.ekeon.fakecertification.fakeinsta.holder.ReactionHolder;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class RecyclerAdapter extends RecyclerView.Adapter {

  private final int TYPE_ACTIOINBAR = 0;
  private final int TYPE_HEADER = 1;
  private final int TYPE_IMAGE = 2;
  private final int TYPE_REACTION = 3;
  private final int TYPE_DUMMY_IMAGE = 4;

  private String filepath = "";

  private String nickname;
  private String content;
  private String hashtag;

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    Context context = parent.getContext();

    switch (viewType) {
      case TYPE_ACTIOINBAR:
        viewHolder = ActionbarHolder.newInstance(context);
        break;
      case TYPE_HEADER:
        viewHolder = HeaderHolder.newInstance(context);
        break;
      case TYPE_IMAGE:
        viewHolder = ImageHolder.newInstance(context);
        break;
      case TYPE_REACTION:
        viewHolder = ReactionHolder.newInstance(context);
        break;
      case TYPE_DUMMY_IMAGE:
        viewHolder = DummyImageHolder.newInstance(context);
        break;
    }
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof HeaderHolder) {
      ((HeaderHolder) holder).setPosition(position, nickname);
    }

    if (holder instanceof ImageHolder) {
      if (position == 2) {
        ((ImageHolder) holder).setImage(filepath);
      }
    }

    if (holder instanceof ReactionHolder) {
      ((ReactionHolder) holder).setPosition(position, nickname, content, hashtag);
    }

    if (holder instanceof DummyImageHolder) {
      ((DummyImageHolder) holder).setPosition(position);
    }

  }

  public void setFilePath(String filepath) {
    this.filepath = filepath;
  }

  public void setMainInfo(String nickname, String content, String hashtag) {
    this.nickname = nickname;
    this.content = content;
    this.hashtag = hashtag;
  }

  public void notifyHeaderReaction() {
    notifyItemChanged(1);
    notifyItemChanged(3);
  }

  @Override
  public int getItemCount() {
    return 12;
  }

  @Override
  public int getItemViewType(int position) {
    if (position == 0) {
      return TYPE_ACTIOINBAR;
    }

    if (position % 3 == 1) {//4,7,10
      return TYPE_HEADER;
    }

    if (position == 2) {
      return TYPE_IMAGE;
    }

    if (position % 3 == 0) {//6,9,12
      return TYPE_REACTION;
    }

    if (position % 3 == 2) {//5,8,11
      return TYPE_DUMMY_IMAGE;
    }
    return super.getItemViewType(position);
  }
}
