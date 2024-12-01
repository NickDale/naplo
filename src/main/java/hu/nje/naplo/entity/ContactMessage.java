package hu.nje.naplo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Objects;

import static java.util.Optional.ofNullable;

@Getter
@Setter

@Entity
@Table(name = "message")


@RequiredArgsConstructor
@AllArgsConstructor
public class ContactMessage extends AbstractEntity {

    private String name;
    @NotBlank
    @Column(nullable = false, length = 50)
    private String title;
    private String email;
    @NotBlank
    private String message;
    private Integer userId;
    @ColumnDefault("current_timestamp()")
    private Instant sentAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", updatable = false, insertable = false)
    private User user;

    public String getSender() {
        return ofNullable(user).map(u ->
                u.getName() + switch (u.getRole()) {
                    case ROLE_STUDENT -> " (tanuló)";
                    case ROLE_TEACHER -> " (tanár)";
                    default -> "";
                }
        ).orElse("Vendég");
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ContactMessage that)) return false;
        return Objects.equals(name, that.name)
                && Objects.equals(email, that.email)
                && Objects.equals(message, that.message)
                && Objects.equals(userId, that.userId)
                && Objects.equals(sentAt, that.sentAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, message, userId, sentAt);
    }
}
