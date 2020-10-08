package com.example.light.shutter;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "shutters")
@SequenceGenerator(name = "SHUTTERS_ID_SEQ", sequenceName = "shutters_id_seq", allocationSize = 1)
public class Shutter {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SHUTTERS_ID_SEQ")
    @Column
    private long id;

    @Column
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shutter shutter = (Shutter) o;
        return id == shutter.id &&
                Objects.equals(name, shutter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
