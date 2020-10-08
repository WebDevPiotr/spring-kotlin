package com.example.light.powerSupply;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "powerSupplies")
@SequenceGenerator(name = "POWER_SUPPLIES_ID_SEQ", sequenceName = "power_supplies_id_seq", allocationSize = 1)
public class PowerSupply {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POWER_SUPPLIES_ID_SEQ")
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
        PowerSupply powerSupply = (PowerSupply) o;
        return id == powerSupply.id &&
                Objects.equals(name, powerSupply.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
