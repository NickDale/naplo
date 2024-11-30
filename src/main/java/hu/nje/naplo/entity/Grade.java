package hu.nje.naplo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "jegy")
public class Grade extends AbstractEntity {

    @Column(name = "diakid")
    private int studentId;

    @NotNull
    @ColumnDefault("current_timestamp()")
    @Column(name = "datum", nullable = false)
    private Instant creationDate;

    @Size(max = 100)
    @Column(name = "tipus", length = 100)
    private String type;

    @Column(name = "ertek")
    private int value;

    @Column(name = "targyid")
    private int subjectId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "diakid",updatable = false, insertable = false)
    private Student student;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "targyid", updatable = false, insertable = false)
    private Subject subject;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Grade grade)) return false;
        return value == grade.value && Objects.equals(student, grade.student) && Objects.equals(id, grade.id)
                && Objects.equals(subject, grade.subject) && Objects.equals(creationDate, grade.creationDate)
                && Objects.equals(type, grade.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, subject, creationDate, value, type);
    }
}