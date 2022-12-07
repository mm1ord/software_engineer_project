package com.douyin.database;


/**
 * 实现该接口的类具备了存入数据库后复制一份的能力，即做到数据库内数据与数据库外隔离的作用。
 * 默认不隔离，所以你对引用对象的数据修改会直接影响数据库内部数据！
 * 重写此方法以获得隔离。
 */
public interface CopyAware<T> extends Cloneable {

    @SuppressWarnings(value = "unchecked")
    default T copy() {
        return (T) this;
    }
}
