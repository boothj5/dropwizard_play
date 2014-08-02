package com.boothj5.dropwizardplay.store;

import com.boothj5.dropwizardplay.core.Person;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class PersonStore {
    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Person> users = new HashMap<>();

    public long addUser(Person user) {
        long id = counter.incrementAndGet();
        users.put(id, user);

        return id;
    }

    public Map<Long, Person> getPeople() {
        return users;
    }

    public Person getPerson(long id) {
        return users.get(id);
    }
}

