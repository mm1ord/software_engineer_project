package com.douyin.database;

import java.util.*;

//线程不安全的，带主键索引的数据库。
public class PrimaryKeyDB<K, V extends PrimaryKeyAware<K> & CopyAware<V>> {
   // 用map作为数据库
    protected HashMap<K, V> db = new HashMap<>();

    //获取数据
    public V findById(K id) {
        V o = db.get(id);
        if (o == null) return null;
        else return o.copy();
    }
//    插入数据 插入失败时返回null，否则返回插入的值
    public V insert(V value) {
        V result = db.putIfAbsent(value.getKey(), value.copy());
        if(result == null) return value;
        else return null;
    }

//    更新数据库，若更新的Key不存在，返回null
    public V update(V value) {
        if(exist(value.getKey())) return null;
        return db.put(value.getKey(), value.copy());
    }


    public boolean exist(K id) {
        return db.get(id) != null;
    }

//    根据id移除数据
    public V delete(K id) {
        return db.remove(id);
    }

//    获得所有值的列表
    public List<V> findAll() {
        Iterator<Map.Entry<K, V>> iter = db.entrySet().iterator();
        List<V> res = new ArrayList<>();
        while(iter.hasNext()) {
            res.add(iter.next().getValue());
        }
        return res;
    }
}
