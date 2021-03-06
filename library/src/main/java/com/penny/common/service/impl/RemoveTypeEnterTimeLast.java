package com.penny.common.service.impl;

import com.penny.common.entity.CacheObject;
import com.penny.common.service.CacheFullRemoveType;

/**
 * Remove type when cache is full.<br/>
 * when cache is full, compare enter time of object in cache, if time is smaller remove it first. also LIFO<br/>
 * 
 */
public class RemoveTypeEnterTimeLast<T> implements CacheFullRemoveType<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(CacheObject<T> obj1, CacheObject<T> obj2) {
        return (obj2.getEnterTime() > obj1.getEnterTime()) ? 1
                : ((obj2.getEnterTime() == obj1.getEnterTime()) ? 0 : -1);
    }
}
