package com.pdfcampus.pdfcampus.Controller;

import com.pdfcampus.pdfcampus.entity.Bookmark;
import com.pdfcampus.pdfcampus.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookmarks")
public class BookmarkController {

    @Autowired
    private BookmarkService bookmarkService;

    @PostMapping
    public ResponseEntity<String> addBookmark(@RequestBody BookmarkRequest bookmarkRequest) {
        bookmarkService.addBookmark(bookmarkRequest.getBookId(), bookmarkRequest.getPage(), bookmarkRequest.getUserId());
        return ResponseEntity.ok("Bookmark added successfully."); // 성공 메시지 추가
    }

    public static class BookmarkRequest {
        private String bookId;
        private int page;
        private String userId;

        public String getBookId() {
            return bookId;
        }

        public void setBookId(String bookId) {
            this.bookId = bookId;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}