package com.itcrowds.guapibooks.mapper;

import com.itcrowds.guapibooks.domain.Review;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReviewMapper {
    List<Review> getOneBookAllReviews(@Param("bookId") int bookId);

    int getOneBookAllReviewsCount(@Param("bookId") int bookId);
}
