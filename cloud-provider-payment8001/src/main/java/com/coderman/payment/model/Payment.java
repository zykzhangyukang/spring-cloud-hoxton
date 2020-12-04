package com.coderman.payment.model;

import java.io.Serializable;

/**
 * @Author zhangyukang
 * @Date 2020/12/4 12:21
 * @Version 1.0
 **/
public class Payment implements Serializable {
    private Long id;
    private String serial;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
