package com.ecobike.service.impl;

import com.ecobike.app.annotation.Singleton;
import com.ecobike.service.PrintService;

@Singleton
public class PrintServiceImpl implements PrintService {

    @Override
    public void println(Object msg) {
        System.out.println(msg.toString());
    }

    @Override
    public void printf(Object msg, Object... args) {
        System.out.printf(msg.toString() + "\n", args);
    }
}
