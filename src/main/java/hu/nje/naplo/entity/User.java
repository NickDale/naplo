package hu.nje.naplo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "felhasznalo")
public class User extends AbstractEntity {

    @Size(max = 200)
    @NotNull
    @Column(name = "nev", nullable = false, length = 200)
    private String name;

    @Size(max = 45)
    @NotNull
    @Column(name = "felhasznalo_nev", unique = true, nullable = false, length = 45)
    private String username;

    @Size(max = 40)
    @NotNull
    @Column(name = "jelszo", nullable = false, length = 40)
    private String password;

    @Size(max = 10)
    @NotNull
    @Column(name = "jogosultsag", nullable = false, length = 10)
    private String role;

    @ColumnDefault("1")
    @Column(name = "aktiv")
    private Boolean active;

    @ColumnDefault("current_timestamp()")
    @Column(name = "inaktivalas_datum")
    private Instant inactivationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name)
                && Objects.equals(username, user.username) && Objects.equals(password, user.password)
                && Objects.equals(role, user.role) && Objects.equals(active, user.active)
                && Objects.equals(inactivationDate, user.inactivationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, username, password, role, active, inactivationDate);
    }
}