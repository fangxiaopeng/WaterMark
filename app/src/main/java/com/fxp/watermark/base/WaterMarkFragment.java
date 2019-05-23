package com.fxp.watermark.base;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import com.fxp.watermark.widget.WaterMarkBg;

import java.util.ArrayList;
import java.util.List;

/**
 * Title:       WaterMarkFragment
 * <p>
 * Package:     com.fxp.watermark.base
 * <p>
 * Author:      fxp
 * <p>
 * Create at:   2019-05-23 16:28
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
public class WaterMarkFragment extends Fragment {


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                    Drawable drawable = new WaterMarkBg(getActivity(), labels, -30, 13);
                    getView().setBackgroundDrawable(drawable);
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
