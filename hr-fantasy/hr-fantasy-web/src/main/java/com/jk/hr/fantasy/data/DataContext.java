package com.jk.hr.fantasy.data;

import com.jk.hr.fantasy.core.Keyed;

import java.io.IOException;

public interface DataContext {

    <T> T load(String key, Class <T> clazz) throws IOException;

    void store(Keyed object) throws IOException;

}
