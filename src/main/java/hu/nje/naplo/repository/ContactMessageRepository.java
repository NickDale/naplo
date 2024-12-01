package hu.nje.naplo.repository;

import hu.nje.naplo.entity.ContactMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Integer> {
}
