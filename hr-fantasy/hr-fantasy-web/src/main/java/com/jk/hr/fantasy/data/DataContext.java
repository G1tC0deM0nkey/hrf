package com.jk.hr.fantasy.data;

import com.jk.hr.fantasy.core.Keyed;

import java.io.IOException;
import java.util.List;

public interface DataContext {

    List<String> list(Class clazz, String ... keys) throws IOException;

    <T> T load(Class <T> clazz, String ... keys) throws IOException;

    void store(Keyed object) throws IOException;

}
