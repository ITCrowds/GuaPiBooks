package com.itcrowds.guapibooks.service.impl;

import com.itcrowds.guapibooks.domain.Review;
import com.itcrowds.guapibooks.mapper.ReviewMapper;
import com.itcrowds.guapibooks.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Resource
    private ReviewMapper reviewMapper;

    @Override
    public List<Review>  getReviewByBookId(int bookId){
        return reviewMapper.getOneBookAllReviews(bookId);
    }

    @Override
    public List<Review> getReviewByReaderId(int readerId) {
        return reviewMapper.getReviewListByReader(readerId);
    }
}
