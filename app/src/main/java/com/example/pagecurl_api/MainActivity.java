package com.example.pagecurl_api;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;

import karacken.curl.PageCurlAdapter;
import karacken.curl.PageSurfaceView;

public class MainActivity extends AppCompatActivity {

    private PageSurfaceView pageSurfaceView;
    private int screen_width;
    private int screen_height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        pageSurfaceView = new PageSurfaceView(this);

        setContentView(pageSurfaceView);

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point(); display.getSize(size);
        screen_width = size.x;  screen_height = size.y;
        String[] res_array=null;
        if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
            res_array=  new String[]{"page1.png", "page2.png", "page3.png"};
        else
            res_array=  new String[]{"page1.png", "page2.png", "page3.png"};

        PageCurlAdapter pageCurlAdapter=new PageCurlAdapter(res_array);
        pageSurfaceView.setPageCurlAdapter(pageCurlAdapter);

    }


    @Override
    protected void onResume() {
        super.onResume();
        pageSurfaceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        pageSurfaceView.onPause();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return pageSurfaceView.onPageTouchEvent(event);
    }

}