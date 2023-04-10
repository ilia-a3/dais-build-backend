package au.com.daisbuild.daisbuild.repository;

import au.com.daisbuild.daisbuild.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {
}
