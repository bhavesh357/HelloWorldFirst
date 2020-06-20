package com.firstspringapp.model;

import javax.persistence.Entity;
import java.util.concurrent.atomic.AtomicLong;

public class Greeting {
    private long counter;
    private String name;
    public Greeting(long counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public long getCounter() {
        return counter;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
