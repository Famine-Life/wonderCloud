package com.wonder.model.base;

import org.springframework.beans.BeanUtils;

public class SuperBuild {
    public SuperBuild() {
    }

    public <T> T build(Class<T> clazz){
        try {
            T t = clazz.newInstance();
            BeanUtils.copyProperties(this, t);
            return t;
        } catch (Throwable var3) {
            try {
                throw var3;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

