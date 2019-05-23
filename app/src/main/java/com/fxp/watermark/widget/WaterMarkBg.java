package com.fxp.watermark.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.List;

public class WaterMarkBg extends Drawable {

    private Context context;

    private Paint paint;

    /**
     * 水印文字列表
     */
    private List<String> labels;

    /**
     * 角度
     */
    private int degress;

    /**
     * 字体大小 单位sp
     */
    private int fontSize;

    /**
     * 密集度
     */
    private int concentration = 5;

    float textWidth = 0;

    int drawColor;

    /**
     * 初始化构造
     *
     * @param context  上下文
     * @param labels   水印文字列表 多行显示支持
     * @param degress  水印角度
     * @param fontSize 水印文字大小
     */
    public WaterMarkBg(Context context, List<String> labels, int degress, int fontSize) {
        context = context.getApplicationContext();
        this.labels = labels;
        this.context = context;
        this.degress = degress;
        this.fontSize = fontSize;

        paint = new Paint();
        paint.setColor(Color.parseColor("#50AEAEAE"));
        paint.setAntiAlias(true);
        paint.setTextSize(sp2px(context, fontSize));

        if (labels.size() > 0) {
            textWidth = paint.measureText(labels.get(0));
        }

        drawColor = Color.parseColor("#FFFFFF");
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        int width = getBounds().right;
        int height = getBounds().bottom;
        canvas.drawColor(drawColor);
        canvas.save();
        canvas.rotate(degress);
        if (labels.size() > 0 && textWidth != 0) {
            int index = 0;
            if (height > 0 && width > 0) {
                for (int positionY = height / 5; positionY <= height; positionY += height / 5) {
                    float fromX = -width + (index++ % 1) * textWidth;
                    for (float positionX = fromX; positionX < width; positionX += textWidth * 5) {
                        int spacing = 0;
                        for (String label : labels) {
                            if (label != null && label.trim().length() > 0 && paint != null) {
                                canvas.drawText(label, positionX, positionY + spacing, paint);
                                spacing = spacing + 50;
                            }
                        }
                    }
                }
            }
        }
        canvas.restore();
    }

    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int alpha) {

    }

    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.UNKNOWN;
    }


    public int sp2px(Context context, float spValue) {
        float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

}
