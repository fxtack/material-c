package com.fxtack.materialc.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * spring boot 自定义配置类, 用于注入配置到 DeleteThread 中
 *
 * @author fxtack
 */
@Component
@Configuration
@ConfigurationProperties(prefix = "delete-thread")
public class DeleteThreadConfig {

    private boolean enable;
    private int second;
    private int minute;
    private int hour;
    private int day;
    private int month;
    private long polling;

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public long getPolling() {
        return polling;
    }

    public void setPolling(long polling) {
        this.polling = polling;
    }
}
