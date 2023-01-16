//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.springboot.live_comm.tencentcloud.exception;

public interface IMessageable {
    String getMessageKey();

    String getDetailMessageKey();

    String getSubCode();

    Object[] getArgs();

    String getDefaultMessage();
}
