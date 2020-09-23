package com.tl.msmservice.service;
/**
 * @Author tl
 * @Date 2020/9/19
 */

import java.util.HashMap;

public interface MsmService {
    boolean send(HashMap<String, Object> param, String phone);
}
