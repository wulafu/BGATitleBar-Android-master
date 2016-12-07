package cn.bingoogolapple.titlebar;

import android.view.View;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/11/9 下午2:47
 * 描述:
 */
public abstract class BGAOnNoDoubleClickListener implements View.OnClickListener {
    private int mThrottleFirstTime = 600;
    private long mLastClickTime = 0;

    public BGAOnNoDoubleClickListener() {
    }

    public BGAOnNoDoubleClickListener(int throttleFirstTime) {
        mThrottleFirstTime = throttleFirstTime;
    }

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastClickTime > mThrottleFirstTime) {
            mLastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    public abstract void onNoDoubleClick(View v);
}