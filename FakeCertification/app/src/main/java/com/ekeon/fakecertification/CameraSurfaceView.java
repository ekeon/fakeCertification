package com.ekeon.fakecertification;

import android.content.Context;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ZoomControls;

/**
 * Created by Ekeon on 2016. 4. 20..
 */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {

  private SurfaceHolder surfaceHolder;
  private Camera camera;

  private ZoomControls zoomControls;
  private int currentZoomLevel = 0, maxZoomLevel = 0;

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

    if(camera.getParameters().isZoomSupported()){
      maxZoomLevel = camera.getParameters().getMaxZoom();

      zoomControls.setIsZoomInEnabled(true);
      zoomControls.setIsZoomOutEnabled(true);

      zoomControls.setOnZoomInClickListener(new OnClickListener(){
        public void onClick(View v){
          if(currentZoomLevel < maxZoomLevel){
            currentZoomLevel++;
            camera.startSmoothZoom(currentZoomLevel);
          }
        }
      });

      zoomControls.setOnZoomOutClickListener(new OnClickListener(){
        public void onClick(View v){
          if(currentZoomLevel > 0){
            currentZoomLevel--;
            camera.startSmoothZoom(currentZoomLevel);
          }
        }
      });
    }
    else
      zoomControls.setVisibility(View.GONE);
  }

  @Override
  public void surfaceDestroyed(SurfaceHolder holder) {
    camera.stopPreview();
    camera.release();
    camera = null;
  }

  public void cameraZoom(ZoomControls zoomControls) {
    this.zoomControls = zoomControls;
  }

  public void getCamera(Camera camera) {
    this.camera = camera;
  }
}
