package com.douyin.database;


/**
 *  实现该接口的类具有获得 primary key 的能力。需要重写 getKey 方法。
 */

public interface PrimaryKeyAware<K> {
    K getKey();
}
