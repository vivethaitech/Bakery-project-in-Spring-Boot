package com.vivi.bakery;

import java.util.ArrayList;
import java.util.List;

public class CombinedException extends RuntimeException {
    
    private List<Exception> exceptions = new ArrayList<>();

    public void addException(Exception e) {
        exceptions.add(e);
    }

    public List<Exception> getExceptions() {
        return exceptions;
    }

    public boolean hasExceptions() {
        return !exceptions.isEmpty();
    }
}

