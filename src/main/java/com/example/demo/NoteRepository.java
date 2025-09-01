package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findByShareUuid(String shareUuid);
}
