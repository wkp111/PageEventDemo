package com.wkp.pageevent.base;

import android.os.Bundle;
import com.wkp.pageevent.info.Event;
import com.wkp.pageevent.inter.PageEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * Created by wkp111 on 2020/5/6.
 * 实现页面间事件传递的基类Fragment
 * <p>
 *     主要负责管理页面间事件监听器的注册及注销，默认该页面支持事件触发
 * </p>
 */
public class EventFragment extends Fragment implements EventPageInit {
    private static final String TAG = "EventFragment";
    /**
     * 事件处理工具
     */
    private EventPageHelper mHelper = new EventPageHelper();

    /**
     * 初始化页面监听
     * @param savedInstanceState savedInstanceState
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper.onCreate(this);
    }

    /**
     * 注销页面监听
     */
    @Override
    public void onDestroy() {
        mHelper.onDestroy();
        super.onDestroy();
    }

    /**
     * 初始化页面事件监听
     * <p>
     *     处理是否开启页面监听，添加监听页面等
     * </p>
     * @return true 开启页面监听
     */
    @Override
    public boolean initPageEvent() {
        return false;
    }

    /**
     * 添加监听页面
     * @param eventPage 事件触发页面
     */
    @Override
    public void addPageEvent(Class<? extends PageEvent> eventPage) {
        mHelper.addPageEvent(eventPage);
    }

    /**
     * 监听页面的事件回调
     * @param event 事件
     */
    @Override
    public void onEvent(@NonNull Event event) {
    }

    /**
     * 初始化页面粘性事件监听
     * <p>
     *     处理是否开启页面粘性事件监听，添加粘性事件监听页面等
     * </p>
     * @return true 开启页面粘性事件监听
     */
    @Override
    public boolean initPageStickEvent() {
        return false;
    }

    /**
     * 添加粘性事件监听页面
     * @param eventPage 事件触发页面
     */
    @Override
    public void addPageStickEvent(Class<? extends PageEvent> eventPage) {
        mHelper.addPageStickEvent(eventPage);
    }

    /**
     * 监听页面的粘性事件回调
     * @param event 事件
     * @return true拦截粘性事件，后续不再传递
     */
    @Override
    public boolean onStickEvent(@NonNull Event event) {
        return false;
    }
}
