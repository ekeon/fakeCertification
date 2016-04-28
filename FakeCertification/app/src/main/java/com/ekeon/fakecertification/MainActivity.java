package com.ekeon.fakecertification;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.ZoomControls;

import com.ekeon.fakecertification.fakeinsta.RecyclerActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  private CameraSurfaceView cameraSurfaceView;
  private Camera camera;

  private int width;
  private int height;

  @Bind(R.id.main_camera_zoom) ZoomControls zoomControls;
  @Bind(R.id.layout_camera) FrameLayout layoutCamera;
  String filepath = "";

  @OnClick(R.id.layout_camera)
  void onClick() {
    if (camera == null) {
      return;
    }
    try {
      camera.autoFocus(new Camera.AutoFocusCallback() {
        @Override
        public void onAutoFocus(boolean success, Camera camera) {
          if (success) {
            camera.takePicture(null, null, takePicture);
          }
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Fresco.initialize(this);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    camera = checkDeviceCamera();
    cameraSurfaceView = new CameraSurfaceView(this, camera);
    cameraSurfaceView.cameraZoom(zoomControls);
    layoutCamera.addView(cameraSurfaceView);

    DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
    width = displayMetrics.widthPixels;
    height = displayMetrics.heightPixels;

    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, width);
    layoutCamera.setLayoutParams(layoutParams);
  }

  private Camera checkDeviceCamera() {
    try {
      camera = Camera.open();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return camera;
  }

  private Camera.PictureCallback takePicture = new Camera.PictureCallback() {
    @Override
    public void onPictureTaken(byte[] data, Camera camera) {
        // TODO Auto-generated method stub
        FileOutputStream fos;
        long now;

        if (data != null) {
          makeDir();
          Bitmap bitmap;
          bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);

          try {
            now = System.currentTimeMillis();
            Date date = new Date(now);
            SimpleDateFormat curTime = new SimpleDateFormat("yyyyMMddHHmmss");
            filepath = Environment.getExternalStorageDirectory().toString() + "/fakeCertification/" + curTime.format(date) + "capture.jpg";

            fos = new FileOutputStream(filepath);
            Log.d("TAG", "fos :" + filepath);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);


            Intent intent = new Intent(MainActivity.this, RecyclerActivity.class);
            intent.putExtra("filepath", filepath);
            startActivity(intent);
          } catch (FileNotFoundException e) {
            e.printStackTrace();
          }
          camera.startPreview();
        }
      }
    };

  private void makeDir() {
    String str = Environment.getExternalStorageState();

    if (TextUtils.equals(str, Environment.MEDIA_MOUNTED)) {
      String dirPath = Environment.getExternalStorageDirectory().toString() + "/fakeCertification";
      File file = new File(dirPath);

      if (!file.exists()) {
        file.mkdirs();
      }
    } else {
      Log.d("TAG", "fail");
    }
  }

  @Override
  protected void onStart() {
    super.onStart();
    camera = checkDeviceCamera();
    cameraSurfaceView.getCamera(camera);
  }
}