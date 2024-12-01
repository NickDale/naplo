package hu.nje.naplo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "felhasznalo")
public class User extends AbstractEntity implements UserDetails {

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

    @Size(max = 100)
    @NotNull
    @Column(name = "jogosultsag", nullable = false, length = 100)
    @Enumerated(EnumType.STRING)
    private Role role;

    @ColumnDefault("1")
    @Column(name = "aktiv")
    private Boolean active;

    @ColumnDefault("current_timestamp()")
    @Column(name = "inaktivalas_datum")
    private Instant inactivationDate;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.getRole().name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return this.active != null && this.active;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof User user)) return false;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}