package hu.nje.naplo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "message")
public class ContactMessage extends AbstractEntity {

    private String name;
    private String email;
    private String message;
    private Integer userId;
    private LocalDateTime sentAt = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "userId", updatable = false, insertable = false)
    private User user;

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
