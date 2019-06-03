package com.medical.repository;

import com.medical.models.Appointment;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class CollectionRepository implements AppointmentRepository {
    private final Map<Long, Appointment> appointments = new HashMap();

    public CollectionRepository() {
    }

    public Optional<Appointment> findById(Long id) {
        return Optional.ofNullable((Appointment)this.appointments.get(id));
    }

    public List<Appointment> getAll() {
        return new ArrayList(this.appointments.values());
    }

    public Long put(Appointment item) {
        this.appointments.put(item.getId(), item);
        return item.getId();
    }

    public List<Long> putAll(List<Appointment> items) {
        List<Long> ids = (List)items.stream().map(Appointment::getId).collect(Collectors.toList());
        Map<Long, Appointment> newValues = (Map)items.stream().collect(Collectors.toMap(Appointment::getId, Function.identity()));
        this.appointments.putAll(newValues);
        return ids;
    }
}
