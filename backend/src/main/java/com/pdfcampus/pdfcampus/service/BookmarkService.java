package com.pdfcampus.pdfcampus.service;

import javax.persistence.EntityNotFoundException;

import com.pdfcampus.pdfcampus.entity.User;
import com.pdfcampus.pdfcampus.entity.Book;
import com.pdfcampus.pdfcampus.entity.Bookmark;
import com.pdfcampus.pdfcampus.repository.BookRepository;
import com.pdfcampus.pdfcampus.repository.BookmarkRepository;
import com.pdfcampus.pdfcampus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookmarkService {

    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;

    public void addBookmark(String bookId, int page, String userId) {
        Book book = bookRepository.findById(Integer.valueOf(bookId))
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        Object userObject = userRepository.findByUid(Integer.valueOf(userId));
        if (userObject == null) {
            throw new EntityNotFoundException("User not found");
        }
        User user = (User) userObject; // Object를 User로 캐스팅

        // 북마크 생성 및 저장
        Bookmark bookmark = new Bookmark();
        bookmark.setPageNumber(page);
        bookmark.setBook(book);
        bookmark.setUser(user); // 조회한 User 객체 설정
    }

    public List<Bookmark> getUserBookmarks(User user) {
        return bookmarkRepository.findByUser(user);
    }

}