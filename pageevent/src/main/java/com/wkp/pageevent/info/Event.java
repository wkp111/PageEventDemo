package com.wkp.pageevent.info;

import android.os.Bundle;
import com.wkp.pageevent.annotations.EventType;
import com.wkp.pageevent.inter.PageEvent;
import java.lang.ref.WeakReference;

/**
 * Created by wkp111 on 2020/5/7.
 * 事件信息
 */
public class Event {
    /**
     * 触发事件的页面
     */
    private WeakReference<? extends PageEvent> eventPage;
    /**
     * 触发的事件类型
     */
    @EventType
    private int eventType;
    /**
     * 事件参数
     */
    private Bundle eventParams;

    public Event() {
    }

    public Event(WeakReference<? extends PageEvent> eventPage, int eventType, Bundle eventParams) {
        this.eventPage = eventPage;
        this.eventType = eventType;
        this.eventParams = eventParams;
    }

    public WeakReference<? extends PageEvent> getEventPage() {
        return eventPage;
    }

    public void setEventPage(WeakReference<? extends PageEvent> eventPage) {
        this.eventPage = eventPage;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public Bundle getEventParams() {
        return eventParams;
    }

    public void setEventParams(Bundle eventParams) {
        this.eventParams = eventParams;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventPage=" + eventPage +
                ", eventType=" + eventType +
                '}';
    }
}
