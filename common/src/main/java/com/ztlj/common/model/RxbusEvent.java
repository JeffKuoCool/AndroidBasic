package com.ztlj.common.model;

/**
 * @date: 2019-09-25
 * @autror: guojian
 * @description:
 */
public class RxbusEvent {
    private int event;
    private Object eventObj;

    public RxbusEvent(int event) {
        this.event = event;
    }

    public RxbusEvent(int event, Object eventObj) {
        this.event = event;
        this.eventObj = eventObj;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    public Object getEventObj() {
        return eventObj;
    }

    public void setEventObj(Object eventObj) {
        this.eventObj = eventObj;
    }
}
