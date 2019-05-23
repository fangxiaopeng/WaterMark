package com.fxp.watermark.base;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.fxp.watermark.widget.WaterMarkBg;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:       WaterMarkActivity
 * <p>
 * Package:     com.fxp.watermark.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019-05-23 16:23
 * <p>
 * Description:
 * <p>
 * <p>
 * Modification History:
 * <p>
 * Date       Author       Version      Description
 * -----------------------------------------------------------------
 * 2019-05-23    fxp       1.0         First Created
 * <p>
 * Github:  https://github.com/fangxiaopeng
 */
public class WaterMarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        addWarterMark();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        addWarterMark();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        addWarterMark();
    }

    public void addWarterMark() {
        //加水印
        if (isAddWaterMark()) {
            try {
                List<String> labels = new ArrayList<>();
                labels.add("卓诺不迷路");
                labels.add("https://github.com/fangxiaopeng");
                if (labels.size() > 0){
                    Drawable drawable = new WaterMarkBg(this, labels, -30, 13);
                    getWindow().setBackgroundDrawable(drawable);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    private boolean isAddWaterMark(){
        return true;
    }

}
