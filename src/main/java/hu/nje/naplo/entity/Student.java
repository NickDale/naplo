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
@Table(name = "diak")
public class Student extends AbstractEntity {

    @Size(max = 100)
    @NotNull
    @Column(name = "nev", nullable = false, length = 100)
    private String studentName;

    @Size(max = 100)
    @NotNull
    @Column(name = "osztaly", nullable = false, length = 100)
    private String className;

    @NotNull
    @Column(name = "fiu", nullable = false)
    private Boolean men = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(this.id, student.id) && Objects.equals(studentName, student.studentName)
                && Objects.equals(className, student.className) && Objects.equals(men, student.men);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, className, gender);
    }
}