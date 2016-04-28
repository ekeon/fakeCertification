package com.ekeon.fakecertification.fakeinsta;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.ekeon.fakecertification.fakeinsta.holder.DummyImageHolder;
import com.ekeon.fakecertification.fakeinsta.holder.HeaderHolder;
import com.ekeon.fakecertification.fakeinsta.holder.ImageHolder;
import com.ekeon.fakecertification.fakeinsta.holder.ReactionHolder;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersAdapter;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class RecyclerAdapter extends RecyclerView.Adapter implements StickyRecyclerHeadersAdapter{

  private final int TYPE_HEADER = 1;
  private final int TYPE_IMAGE = 2;
  private final int TYPE_REACTION = 3;
  private final int TYPE_DUMMY_IMAGE = 4;

  private String filepath = "";

  private String nickname;
  private String content;
  private String hashtag;

  public void setFilePath(String filepath) {
    this.filepath = filepath;
  }

  public void setMainInfo(String nickname, String content, String hashtag) {
    this.nickname = nickname;
    this.content = content;
    this.hashtag = hashtag;
  }

  public void notifyHeaderReaction() {
    notifyItemChanged(0);
    notifyItemChanged(2);
  }

  @Override
  public long getHeaderId(int position) {
    return (position) / 2;
  }

  @Override
  public RecyclerView.ViewHolder onCreateHeaderViewHolder(ViewGroup parent) {
    return HeaderHolder.newInstance(parent.getContext());
  }

  @Override
  public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (holder instanceof HeaderHolder) {
      ((HeaderHolder) holder).setPosition(position, nickname);
    }
  }

  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder viewHolder = null;
    Context context = parent.getContext();

    switch (viewType) {
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
    if (holder instanceof ImageHolder) {
      if (position == 0) {
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


  @Override
  public int getItemCount() {
    return 8;
  }

  @Override
  public int getItemViewType(int position) {
    if (position == 0) {
      return TYPE_IMAGE;
    }

    if (position % 2 == 1 && position > 0) {
      return TYPE_REACTION;
    }

    if (position % 2 == 0 && position > 0) {
      return TYPE_DUMMY_IMAGE;
    }
    return super.getItemViewType(position);
  }
}
