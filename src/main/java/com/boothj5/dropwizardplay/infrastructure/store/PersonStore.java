package com.boothj5.dropwizardplay.infrastructure.store;

import com.boothj5.dropwizardplay.core.Person;
import com.codahale.metrics.Counter;
import com.codahale.metrics.MetricRegistry;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import static com.codahale.metrics.MetricRegistry.name;

public class PersonStore {
    private final AtomicLong idGenerator = new AtomicLong();
    private final Map<Long, Person> users = new HashMap<>();
    private final Counter counter;

    public PersonStore(MetricRegistry metrics) {
        this.counter = metrics.counter(name(PersonStore.class, "people"));
    }

    public long addUser(Person user) {
        counter.inc();
        long id = this.idGenerator.incrementAndGet();
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

