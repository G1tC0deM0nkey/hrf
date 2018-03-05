package com.jk.hr.fantasy.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.hr.fantasy.FantasyHorseracingConfiguration;
import com.jk.hr.fantasy.core.Keyed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("fileDataContext")
public class FileDataContext implements DataContext {

    private FantasyHorseracingConfiguration configuration;

    private String root;

    private File rootFile;

    private ObjectMapper mapper;

    public FileDataContext() {
    }

    @Autowired
    public void setConfiguration(FantasyHorseracingConfiguration configuration) {

        this.configuration = configuration;

        this.root = configuration.getDataDirectory();
        this.rootFile = new File(root);

        if(!this.rootFile.exists()) {
            this.rootFile.mkdirs();
        }

        this.mapper = new ObjectMapper();
    }

    @Override
    public List<String> list(Class clazz, String ... keys) throws IOException {

        String fileName = clazz.getSimpleName() + "-";

        if(keys != null) {
            for(String k : keys) {
                fileName = fileName + k + "-";
            }
        }

        final String fileNameToFilter = fileName;

        String[] files = rootFile.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.startsWith(fileNameToFilter);
            }
        });

        List <String> filesFound = new ArrayList<>();
        for(String f : files) {
            filesFound.add(f.substring(fileNameToFilter.length(), f.length() - 5));
        }

        return filesFound;

    }

    @Override
    public <T> T load(Class<T> clazz, String ... keys) {

        try {
            if (keys == null || keys.length < 1) {
                throw new UnsupportedOperationException("Unable to load " + clazz.getSimpleName() + " without a key");
            }

            String key = "";

            for (String k : keys) {
                key = key + k + "-";
            }
            key = key.substring(0, key.length() - 1);

            String fileName = clazz.getSimpleName() + "-" + key + ".json";
            T object = mapper.readValue(new File(root + "/" + fileName), clazz);
            return object;
        }
        catch(Exception e) {
            return null;
        }
    }

    @Override
    public void store(Keyed object) throws IOException {
        String fileName = object.getClass().getSimpleName() + "-" + object.key() + ".json";
        mapper.writeValue(new File(root + "/" + fileName), object);
    }

}
