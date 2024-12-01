package hu.nje.naplo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "diak")

@NoArgsConstructor
public class Student extends AbstractEntity {

    @Getter
    @Setter
    @Size(max = 100)
    @NotNull
    @Column(name = "nev", nullable = false, length = 100)
    private String studentName;

    @Getter
    @Setter
    @Size(max = 100)
    @NotNull
    @Column(name = "osztaly", nullable = false, length = 100)
    private String className;

    @Column(name = "fiu", nullable = false)
    private int man;

    public Student(String studentName, String className, boolean man) {
        this.studentName = studentName;
        this.className = className;
        this.man = man ? -1 : 0;
    }

    public boolean isMan() {
        return this.man != 0;
    }

    public void setMan(final boolean isMen) {
        this.man = isMen ? -1 : 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(this.id, student.id) && Objects.equals(studentName, student.studentName)
                && Objects.equals(className, student.className) && Objects.equals(man, student.man);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentName, className, man);
    }
}