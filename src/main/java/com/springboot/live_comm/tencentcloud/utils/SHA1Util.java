package com.springboot.live_comm.tencentcloud.utils;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;

import java.util.Collections;
import java.util.List;

public class SHA1Util {
    public static String sign(List<String> values, String ticket) {

        if (values == null) {
            throw new NullPointerException("values is null");
        }
        values.removeAll(Collections.singleton(null));// remove null
        values.add(ticket);
        Collections.sort(values);
        StringBuilder sb = new StringBuilder();
        for (String s : values) {
            sb.append(s);
        }
        return Hashing.sha1().hashString(sb, Charsets.UTF_8).toString().toUpperCase();
    }
}
