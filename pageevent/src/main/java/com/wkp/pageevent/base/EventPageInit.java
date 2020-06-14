package com.wkp.pageevent.base;

import com.wkp.pageevent.inter.PageEvent;
import com.wkp.pageevent.inter.PageEventListener;
import com.wkp.pageevent.inter.PageStickEventListener;

/**
 * 初始Activity或Fragment的事件监听初始化
 */
public interface EventPageInit extends PageEventListener, PageEvent, PageStickEventListener {
    /**
     * 初始化页面事件监听
     * <p>
     *     处理是否开启页面监听，添加监听页面等
     * </p>
     * @return true 开启页面监听
     */
    boolean initPageEvent();

    /**
     * 添加监听页面
     * @param eventPage 事件触发页面
     */
    void addPageEvent(Class<? extends PageEvent> eventPage);

    /**
     * 初始化页面粘性事件监听
     * <p>
     *     处理是否开启页面粘性事件监听，添加粘性事件监听页面等
     * </p>
     * @return true 开启页面粘性事件监听
     */
    boolean initPageStickEvent();

    /**
     * 添加粘性事件监听页面
     * @param eventPage 事件触发页面
     */
    void addPageStickEvent(Class<? extends PageEvent> eventPage);
}
