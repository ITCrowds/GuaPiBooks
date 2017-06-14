package com.itcrowds.guapibooks.service;

import com.itcrowds.guapibooks.domain.Review;
import java.util.List;

public interface ReviewService {
    List<Review> getReviewByBookId(int bookId);

    List<Review> getReviewByReaderId(int readerId);

    void setReaderBookReview(int readerId, int bookId, String bookReview);
}
