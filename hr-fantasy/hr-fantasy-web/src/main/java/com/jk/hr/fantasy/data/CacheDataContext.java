package com.jk.hr.fantasy.data;

import com.jk.hr.fantasy.core.Keyed;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("dataContext")
public class CacheDataContext implements DataContext {

    private Map<String, Object> data;

    @Resource(name="fileDataContext")
    private FileDataContext fileDataContext;

    public CacheDataContext() {
        this.data = new HashMap<>();
        this.fileDataContext = new FileDataContext("data");
    }

    @Override
    public List<String> list(Class clazz, String ... keys) throws IOException {
        List <String> loaded = fileDataContext.list(clazz, keys);
        return loaded;
    }

    @Override
    public <T> T load(Class<T> clazz, String ... keys) throws IOException{

        if(keys == null || keys.length < 1) {
            throw new UnsupportedOperationException("Unable to load " + clazz.getSimpleName() + " without a key");
        }

        String key = "";
        for(String k : keys) {
            key = key + k + "-";
        }
        key = key.substring(0, key.length()-1);

        if(data.containsKey(key)) {
            return clazz.cast(data.get(key));
        }
        else {
            return fileDataContext.load(clazz, keys);
        }
    }

    @Override
    public void store(Keyed object) throws IOException {
        this.data.put(object.key(), object);
        fileDataContext.store(object);
    }
}
