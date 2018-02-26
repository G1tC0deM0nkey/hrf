package com.jk.hr.fantasy.data;

import com.jk.hr.fantasy.core.Keyed;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CacheDataContext implements DataContext {

    private Map<String, Object> data;

    private FileDataContext fileDataContext;

    public CacheDataContext() {
        this.data = new HashMap<>();
        this.fileDataContext = new FileDataContext("data");
    }

    @Override
    public <T> T load(String key, Class<T> clazz) throws IOException{
        if(data.containsKey(key)) {
            return clazz.cast(data.get(key));
        }
        else {
            return fileDataContext.load(key, clazz);
        }
    }

    @Override
    public void store(Keyed object) throws IOException {
        this.data.put(object.key(), object);
        fileDataContext.store(object);
    }
}
