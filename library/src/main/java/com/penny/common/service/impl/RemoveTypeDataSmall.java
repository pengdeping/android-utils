package com.penny.common.service.impl;

import com.penny.common.entity.CacheObject;
import com.penny.common.service.CacheFullRemoveType;
import com.penny.common.util.ObjectUtils;

/**
 * Remove type when cache is full.<br/>
 * when cache is full, compare data of object in cache, if data is smaller remove it first.<br/>
 * 
 */
public class RemoveTypeDataSmall<T> implements CacheFullRemoveType<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(CacheObject<T> obj1, CacheObject<T> obj2) {
        return ObjectUtils.compare(obj1.getData(), obj2.getData());
    }
}
