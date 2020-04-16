package com.penny.common.service.impl;

import com.penny.common.entity.CacheObject;
import com.penny.common.service.CacheFullRemoveType;

/**
 * Remove type when cache is full. not remove any one, it means nothing can be put later<br/>
 * 
 */
public class RemoveTypeNotRemove<T> implements CacheFullRemoveType<T> {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(CacheObject<T> obj1, CacheObject<T> obj2) {
        return 0;
    }
}
