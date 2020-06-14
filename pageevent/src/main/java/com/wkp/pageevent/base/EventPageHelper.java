package com.wkp.pageevent.base;

import com.wkp.pageevent.helper.EventHelper;
import com.wkp.pageevent.inter.PageEvent;
import com.wkp.pageevent.log.LogHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.NonNull;

/**
 * 提取Activity或Fragment的共有逻辑
 */
final class EventPageHelper {
    private static final String TAG = "EventPageHelper";
    /**
     * 是否开启页面事件监听，默认不开启
     */
    private boolean mPageEventEnable;
    /**
     * 当前Activity需要监听事件的页面集合
     */
    private List<Class<? extends PageEvent>> mEventList;

    /**
     * 是否开启页面粘性事件监听，默认不开启
     */
    private boolean mPageStickEventEnable;
    /**
     * 当前Activity需要监听粘性事件的页面集合
     */
    private List<Class<? extends PageEvent>> mStickEventList;
    private WeakReference<EventPageInit> mPageInit;

    /**
     * 初始化
     * @param init 事件页面
     */
    void onCreate(@NonNull EventPageInit init) {
        mPageInit = new WeakReference<>(init);
        // 普通事件监听初始化
        mPageEventEnable = init.initPageEvent();
        if (mPageEventEnable && mEventList != null) {
            for (Class<? extends PageEvent> eventPage : mEventList) {
                EventHelper.registerEventPage(init, eventPage);
            }
        }
        // 粘性事件监听初始化
        mPageStickEventEnable = init.initPageStickEvent();
        if (mPageStickEventEnable && mStickEventList != null) {
            for (Class<? extends PageEvent> eventPage : mStickEventList) {
                EventHelper.registerStickEventPage(init, eventPage);
            }
        }
        LogHelper.i(TAG, "activity: " + this +
                ", mPageEventEnable: " + mPageEventEnable +
                ", mPageStickEventEnable: " + mPageStickEventEnable);
    }

    /**
     * 注销
     */
    void onDestroy() {
        if (mPageInit == null || mPageInit.get() == null) {
            return;
        }
        // 普通事件监听注销
        if (mPageEventEnable && mEventList != null) {
            for (Class<? extends PageEvent> eventPage : mEventList) {
                EventHelper.unregisterEventPage(mPageInit.get(), eventPage);
            }
            mEventList.clear();
            mEventList = null;
        }
        // 粘性事件监听注销
        if (mPageStickEventEnable && mStickEventList != null) {
            for (Class<? extends PageEvent> eventPage : mStickEventList) {
                EventHelper.unregisterStickEventPage(mPageInit.get(), eventPage);
            }
            mStickEventList.clear();
            mStickEventList = null;
        }
    }

    /**
     * 添加监听页面
     * @param eventPage 事件触发页面
     */
    void addPageEvent(Class<? extends PageEvent> eventPage) {
        if (eventPage == null) {
            return;
        }
        if (mEventList == null) {
            mEventList = new ArrayList<>();
        }
        if (mEventList.contains(eventPage)) {
            return;
        }
        mEventList.add(eventPage);
    }

    /**
     * 添加粘性事件监听页面
     * @param eventPage 事件触发页面
     */
    void addPageStickEvent(Class<? extends PageEvent> eventPage) {
        if (eventPage == null) {
            return;
        }
        if (mStickEventList == null) {
            mStickEventList = new ArrayList<>();
        }
        if (mStickEventList.contains(eventPage)) {
            return;
        }
        mStickEventList.add(eventPage);
    }
}
