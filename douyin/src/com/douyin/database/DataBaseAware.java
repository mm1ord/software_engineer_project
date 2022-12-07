package com.douyin.database;

/**
 * 整合 CopyAware 和 PrimaryKeyAware
 */
public interface DataBaseAware<K, V> extends PrimaryKeyAware<K>, CopyAware<V> {

}
