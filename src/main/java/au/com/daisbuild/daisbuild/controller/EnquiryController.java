package au.com.daisbuild.daisbuild.controller;

import au.com.daisbuild.daisbuild.payload.EnquiryDetails;
import au.com.daisbuild.daisbuild.payload.StatusResponse;
import au.com.daisbuild.daisbuild.service.EnquiryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/enquiry")
public class EnquiryController {
    private EnquiryService enquiryService;

    public EnquiryController(EnquiryService enquiryService) {
        this.enquiryService = enquiryService;
    }
    @PostMapping("new")
    public ResponseEntity<StatusResponse> newEnquiry(@RequestBody EnquiryDetails enquiry) {
        return ResponseEntity.ok(enquiryService.addEnquiry(enquiry));
    }
}
