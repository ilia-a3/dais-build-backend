package au.com.daisbuild.daisbuild.repository;

import au.com.daisbuild.daisbuild.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
