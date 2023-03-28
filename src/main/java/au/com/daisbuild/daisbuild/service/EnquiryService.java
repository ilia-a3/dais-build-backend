package au.com.daisbuild.daisbuild.service;

import au.com.daisbuild.daisbuild.payload.EnquiryDetails;
import au.com.daisbuild.daisbuild.payload.StatusResponse;

public interface EnquiryService {
    StatusResponse addEnquiry(EnquiryDetails enquiry);
}
