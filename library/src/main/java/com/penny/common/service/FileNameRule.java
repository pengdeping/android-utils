package com.penny.common.service;

import com.penny.common.service.impl.ImageSDCardCache;

import java.io.Serializable;

/**
 * File name rule, used when saving images in {@link ImageSDCardCache}
 * 
 */
public interface FileNameRule extends Serializable {

    /**
     * get file name, include suffix, it's optional to include folder.
     * 
     * @param imageUrl the url of image
     * @return
     */
    public String getFileName(String imageUrl);
}
