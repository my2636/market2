package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Storage<T> {
    private final UUID id;
    protected List<T> list;

    public Storage() {
        this.id = UUID.randomUUID();
        this.list = new ArrayList<>();
    }

    public UUID getId() {
        return id;
    }

    public List<T> getList() {
        return list;
    }
}
