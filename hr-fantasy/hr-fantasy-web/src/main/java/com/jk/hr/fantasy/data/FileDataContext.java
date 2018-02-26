package com.jk.hr.fantasy.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.hr.fantasy.core.Keyed;

import java.io.File;
import java.io.IOException;

public class FileDataContext implements DataContext {

    private String root;

    private File rootFile;

    private ObjectMapper mapper;

    public FileDataContext(String root) {
        this.root = root;
        this.rootFile = new File(root);

        if(!this.rootFile.exists()) {
            this.rootFile.mkdirs();
        }

        this.mapper = new ObjectMapper();
    }

    @Override
    public <T> T load(String key, Class<T> clazz) throws IOException {
        String fileName = clazz.getSimpleName() + "-" + key + ".json";
        T object = mapper.readValue(new File(root + "/" + fileName), clazz);
        return object;
    }

    @Override
    public void store(Keyed object) throws IOException {
        String fileName = object.getClass().getSimpleName() + "-" + object.key() + ".json";
        mapper.writeValue(new File(root + "/" + fileName), object);
    }

}
