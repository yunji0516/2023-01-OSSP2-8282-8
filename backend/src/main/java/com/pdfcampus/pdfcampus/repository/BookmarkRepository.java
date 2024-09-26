package com.pdfcampus.pdfcampus.repository;

import com.pdfcampus.pdfcampus.entity.Bookmark;
import com.pdfcampus.pdfcampus.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUser(User user);
}