package au.com.daisbuild.daisbuild.service.impl;

import au.com.daisbuild.daisbuild.Exception.APIException;
import au.com.daisbuild.daisbuild.entity.Review;
import au.com.daisbuild.daisbuild.payload.ReviewDto;
import au.com.daisbuild.daisbuild.repository.ReviewRepository;
import au.com.daisbuild.daisbuild.service.ReviewService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;
    private ModelMapper mapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ModelMapper mapper) {
        this.reviewRepository = reviewRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ReviewDto> getReviews() {
        List<Review> reviews = reviewRepository.findAll();
        return reviews.stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @Override
    public ReviewDto getReviewById(long id) {
        Review review = reviewRepository.findById(id).orElseThrow(() -> APIException.NOT_FOUND("Review ID"));
        return mapToDto(review);
    }

    @Override
    public ReviewDto addReview(ReviewDto review) {
        Review entity = reviewRepository.save(mapToEntity(review));
        return mapToDto(entity);
    }

    @Override
    public String deleteReviewById(long id) {
        if (reviewRepository.existsById(id)){
            reviewRepository.deleteById(id);
            return "Successfully Deleted!";
        }
        throw APIException.NOT_FOUND("Review ID");
    }

    private ReviewDto mapToDto(Review entity) {
        return mapper.map(entity, ReviewDto.class);
    }
    private Review mapToEntity(ReviewDto dto) {
        return mapper.map(dto, Review.class);
    }
}
