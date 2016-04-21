package com.ekeon.fakecertification;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

  SurfaceHolder surfaceHolder;
  Camera camera;

  public CameraSurfaceView(Context context, Camera camera) {
    super(context);
    this.camera = camera;
    this.surfaceHolder = getHolder();
    this.surfaceHolder.addCallback(this);
  }

  @Override
  public void surfaceCreated(SurfaceHolder holder) {
    try {
      this.camera.setPreviewDisplay(holder);  //프리뷰를 홀더로
      this.camera.startPreview();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
    camera.setDisplayOrientation(90);
    camera.startPreview();
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    camera.stopPreview();
    camera.release();
    camera = null;
  }

  public void getCamera(Camera camera) {
    this.camera = camera;
  }
}
