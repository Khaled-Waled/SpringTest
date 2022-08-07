package com.test.persitence;

import java.util.List;

public interface IDAO<T>
{
    public boolean insert(T t);
    public List<T> retrieve(String filter);
}
