package com.ekeon.fakecertification;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created by Ekeon on 2016. 4. 21..
 */
public class ScaleImageView extends ImageView {
  private boolean isScaleToWidth = true;

  public ScaleImageView(Context context) {
    this(context, null, 0);
  }

  public ScaleImageView(Context context, AttributeSet attrs) {
    this(context, attrs, 0);
  }

  public ScaleImageView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
    setAttrs(context, attrs);
    init();
  }

  private void init() {
    this.setScaleType(ScaleType.CENTER_INSIDE);
  }

  public void setScaleToWidth(boolean isScaleToWidth) {
    this.isScaleToWidth = isScaleToWidth;
  }

  private void setAttrs(Context context, AttributeSet attrs) {
    if (attrs == null) {
      return;
    }

    TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ScaleImage);
    boolean isScaleToWidth = ta.getBoolean(R.styleable.ScaleImage_scaleToWidth, true);

    setScaleToWidth(isScaleToWidth);
    ta.recycle();
  }

  @Override
  public void setImageResource(int id) {
    super.setImageResource(id);
  }

  public interface ImageChangeListener {
    // a callback for when a change has been made to this imageView
    void changed(boolean isEmpty);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

    int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
    int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
    int width = View.MeasureSpec.getSize(widthMeasureSpec);
    int height = View.MeasureSpec.getSize(heightMeasureSpec);

    /**
     * if both width and height are set scale width first. modify in future if necessary
     */

    if (getDrawable() == null || getDrawable().getIntrinsicWidth() == 0 || getDrawable().getIntrinsicHeight() == 0) {
      // nothing to measure
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
      return;
    }

    if(isScaleToWidth) {
      if (widthMode == View.MeasureSpec.EXACTLY || widthMode == View.MeasureSpec.AT_MOST) {
        setScaleToWidth(width);
      } else {
        throw new IllegalStateException("width or height needs to be set to match_parent or a specific dimension");
      }
    } else {
      if (heightMode == View.MeasureSpec.EXACTLY || heightMode == View.MeasureSpec.AT_MOST) {
        setScaleToHeight(height);
      } else {
        throw new IllegalStateException("width or height needs to be set to match_parent or a specific dimension");
      }
    }
  }

  private void setScaleToWidth(int width) {
    int iw = this.getDrawable().getIntrinsicWidth();
    int ih = this.getDrawable().getIntrinsicHeight();
    int newHeight = width * ih / iw;
    setMeasuredDimension(width, newHeight);
  }

  private void setScaleToHeight(int height) {
    int iw = this.getDrawable().getIntrinsicWidth();
    int ih = this.getDrawable().getIntrinsicHeight();

    int newWidth = height * iw / ih;
    setMeasuredDimension(newWidth, height);
  }

}

