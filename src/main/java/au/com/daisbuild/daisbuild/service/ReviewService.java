package au.com.daisbuild.daisbuild.service;

import au.com.daisbuild.daisbuild.payload.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> getReviews();
    ReviewDto getReviewById(long id);
    ReviewDto addReview(ReviewDto review);
    String deleteReviewById(long id);
}
