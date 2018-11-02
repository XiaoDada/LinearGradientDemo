package com.fd.lineargradientdemo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.*;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;

/**
 * @author fengda
 * @time 2018/10/31 15:08
 * @desc TODO
 * @updateAuthor Author
 * @updateDate Date
 */
public class LightningView extends View {
    private Shader mGradient;
    private Shader mGradient2;
    private Matrix mGradientMatrix;
    private Matrix mGradientMatrix2;
    private Paint mPaint;
    private int mViewWidth = 0, mViewHeight = 0;
    private float mTranslateX = 0, mTranslateY = 0;
    private boolean mAnimating = false;
    private Rect rect;
    private ValueAnimator valueAnimator;
    private boolean autoRun = true; //是否自动运行动画
    private Paint paint;
    private Resources mResources;
    private Paint mBitPaint;
    private Bitmap mBitmap;
    private Rect mSrcRect, mDestRect;
    private float scale;
    private float alpha;


    public LightningView(Context context) {
        super(context);
        init();
    }

    public LightningView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LightningView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        rect = new Rect();
        mPaint = new Paint();
        paint = new Paint();
//        initGradientAnimator();
        mResources = getResources();
        initBitmap();
        initPaint();
    }

    private void initPaint() {

    }

    private void initBitmap() {

    }


    public void setAutoRun(boolean autoRun) {
        this.autoRun = autoRun;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e("fengda", "onMeasure:+++++ " );
        rect.set(0, 0, getWidth(), getHeight());
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("fengda", "onSizeChanged:+++++++++ ");
        if (mViewWidth == 0) {
            mViewWidth = getWidth();
            mViewHeight = getHeight();
            if (mViewWidth > 0) {
//                new int[]{0x00ffffff, 0x73ffffff, 0x00ffffff,  0x99ffffff, 0x00ffffff},
//                        new float[]{0.2f,       0.35f,      0.5f,        0.7f,      1},
                int colorStart = 0x00FFffff;
                int color1 = 0x36ffffff;
                int color2 = 0x26ffffff;
                int color3 = 0x8Fffffff;
                int colorEnd = 0x00ffffff;
                int[] ints = {colorStart,color3,  colorEnd};
                float[] floats = {0.00f, 0.9f,0.91f};
                //亮光闪过
                mGradient2 = new LinearGradient(0, 0, mViewWidth/2+40, mViewHeight/2,
                        ints,
                        floats,
                        Shader.TileMode.CLAMP);
                paint.setAntiAlias(false);
                paint.setStrokeCap(Paint.Cap.ROUND);
                paint.setShader(mGradient2);
                mGradientMatrix2 = new Matrix();
                mGradientMatrix2.setTranslate(-2 * mViewWidth, -2*mViewHeight);
                mGradient2.setLocalMatrix(mGradientMatrix2);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                paint.setAntiAlias(true);
                paint.setStrokeWidth(20);
                //亮光闪过
                mGradient = new LinearGradient(0, 0, mViewWidth/2, mViewHeight/2,
                        ints,
                        floats,
                        Shader.TileMode.CLAMP);
                mPaint.setAntiAlias(true);
                mPaint.setShader(mGradient);
                mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
                mGradientMatrix = new Matrix();
                mGradientMatrix.setTranslate(-2 * mViewWidth, -2*mViewHeight);
                mGradient.setLocalMatrix(mGradientMatrix);
                rect.set(0, 0, w, h);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e("fengda", "onDraw:+++++++ ");
//        //获取View的宽高
//        int width = getWidth();
//        int height = getHeight();
//        int colorStart = 0x00FFffff;
//        int color1 = 0x36ffffff;
//        int color2 = 0x26ffffff;
//        int color3 = 0xFFffffff;
//        int colorEnd = 0x00ffffff;
//        int[] ints = {colorStart,color3,  colorEnd};
//        float[] floats = {0.00f, 0.9f,0.1f};
//
//        Paint paint = new Paint();
//        LinearGradient backGradient = new LinearGradient(0, 0, width/2, height/2,
//                ints, floats, Shader.TileMode.CLAMP);
//
//        paint.setAntiAlias(false);
//        paint.setStrokeCap(Paint.Cap.ROUND);
//        paint.setShader(backGradient);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
//
//
////        paint.setColor(Color.parseColor("#EE8976"));
//        paint.setAntiAlias(true);
//        paint.setStrokeWidth(20);
//        canvas.drawLine(0, 0, mViewWidth/3, 0, paint);

//

//
//        int colorStart = 0x00FFffff;
//        int color1 = 0x36ffffff;
//        int color2 = 0x26ffffff;
//        int color3 = 0xFFffffff;
//        int colorEnd = 0x00ffffff;
//        int[] ints = {colorStart,color3,  colorEnd};
//        float[] floats = {0.00f, 0.9f,0.1f};
//
//        Paint paint = new Paint();
//        LinearGradient backGradient = new LinearGradient(0, 0, width/2, height/2,
//                ints, floats, Shader.TileMode.CLAMP);
//
//        paint.setAntiAlias(false);
//        paint.setShader(backGradient);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
//
//        canvas.drawRect(0, 0, width, height, paint);
        initAnimation();
        if (mBitmap != null) {
//            bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.star);
            Rect mSrcRect, mDestRect;
            int mBitWidth=mBitmap.getWidth();
            int mBitHeight=mBitmap.getHeight();
//            mSrcRect = new Rect(0, 0, mBitWidth, mBitHeight);
            mDestRect = new Rect(0, 0, mBitWidth, mBitHeight);
//            Rect dst = new Rect(100, 100, 200, 200 );
            canvas.scale(scale, scale, 20 / 2, 30/ 2);
            mBitPaint.setAlpha((int) alpha);
            canvas.drawBitmap(mBitmap, null, mDestRect, mBitPaint);

        }
//        if (mAnimating && mGradientMatrix != null&&mGradientMatrix2 != null) {
//            canvas.drawLine(0, 0, 2*mViewWidth, 0, paint);
//            canvas.drawRect(rect, mPaint);
//
//        }


    }


    //初始化动画及绘制元素的对象
    private void initAnimation() {
        mBitmap = ((BitmapDrawable) mResources.getDrawable(R.drawable.star))
                .getBitmap();
        mBitPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitPaint.setFilterBitmap(true);
        mBitPaint.setDither(true);
        mBitPaint.setAlpha(255);
        ValueAnimator scaleAnim = ValueAnimator.ofFloat(0, 250, 0);
        scaleAnim.setInterpolator(new LinearInterpolator());
        scaleAnim.setDuration(1000);
        scaleAnim.setRepeatCount(-1);
        scaleAnim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("fengda", "onAnimationUpdate:动画开始了执行     "+animation.getAnimatedValue());
                boolean flag = false;
                    if (flag) {
                        scale = ((float) animation.getAnimatedValue()) / 250;
                       alpha = (float) animation.getAnimatedValue();
                    } else {
                        scale = 1 - ((float) animation.getAnimatedValue()) / 250;
                        alpha = 255 - (float) animation.getAnimatedValue();
                    }
                    flag = !flag;
                postInvalidate();
            }
        });
        scaleAnim.start();
    }
    private void initGradientAnimator() {
        valueAnimator = ValueAnimator.ofFloat(0, 1);
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("fengda", "onAnimationUpdate:动画开始了执行 ");
                float v = (Float) animation.getAnimatedValue();
                //❶ 改变每次动画的平移x、y值，范围是[-2mViewWidth, 2mViewWidth]
                mTranslateX = 4 * mViewWidth * v - mViewWidth * 2;
                mTranslateY = mViewHeight * v;
                //❷ 平移matrix, 设置平移量
                if (mGradientMatrix != null) {
                    mGradientMatrix.setTranslate(mTranslateX, mTranslateY);
                }

                if (mGradientMatrix2 != null) {
                   float v1=v*v*1000+10;
                    mGradientMatrix2.setTranslate(mTranslateX, mTranslateY+v1);
                    Log.e("mTranslateY", "mTranslateY: "+mTranslateY+"____________"+ v1);
                }
                //❸ 设置线性变化的matrix
                if (mGradient != null) {
                    mGradient.setLocalMatrix(mGradientMatrix);
                    mGradient2.setLocalMatrix(mGradientMatrix2);
                }
                //❹ 重绘
                invalidate();
            }
        });
        if (autoRun) {
            valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                @Override
                public void onGlobalLayout() {
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    mAnimating = true;
                    Log.e("fengda", "onGlobalLayout: 动画开启");
                    if (valueAnimator != null) {
                        valueAnimator.start();
                    }
                }
            });
        }
    }

    //停止动画
    public void stopAnimation() {
        if (mAnimating && valueAnimator != null) {
            mAnimating = false;
            valueAnimator.cancel();
            invalidate();
        }
    }

    //开始动画
    public void startAnimation() {
        if (!mAnimating && valueAnimator != null) {
            mAnimating = true;
            valueAnimator.start();
        }
    }

}
