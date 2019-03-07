package com.nicholas.phonebook.repository;

import com.nicholas.phonebook.entity.EntryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntryRepository extends JpaRepository<EntryEntity, Integer> {
    List<EntryEntity> findByNameContainingIgnoreCase(String name);
}
