package hu.nje.naplo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "targy")
public class Subject extends AbstractEntity {

    @Size(max = 300)
    @NotNull
    @Column(name = "nev", nullable = false, length = 300)
    private String name;

    @Size(max = 100)
    @Column(name = "kategoria", length = 100)
    private String category;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subject subject)) return false;
        return Objects.equals(this.id, subject.id) && Objects.equals(name, subject.name) && Objects.equals(category, subject.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id,name, category);
    }
}