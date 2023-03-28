package au.com.daisbuild.daisbuild.service.impl;

import au.com.daisbuild.daisbuild.entity.Enquiry;
import au.com.daisbuild.daisbuild.payload.EnquiryDetails;
import au.com.daisbuild.daisbuild.payload.StatusResponse;
import au.com.daisbuild.daisbuild.service.EnquiryService;
import au.com.daisbuild.repository.EnquiryRepository;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EnquiryServiceImpl implements EnquiryService {

    private JavaMailSender mailSender;
    private EnquiryRepository repository;

    public EnquiryServiceImpl(JavaMailSender mailSender, EnquiryRepository repository) {
        this.mailSender = mailSender;
        this.repository = repository;
    }

    @Override
    public StatusResponse addEnquiry(EnquiryDetails enquiry) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("daisbuild@daisbuild.com.au");
        message.setTo("daniel@daisbuild.com.au");
        message.setSubject("New Enquiry for you daniel!!");
        message.setText("Hello Daniel, you received a new enquiry!! \n" +
                "Name: "+ enquiry.getName() +" \n" +
                "Email: " + enquiry.getEmail() + " \n" +
                "Phone: " + enquiry.getPhone() + " \n" +
                "Postcode: " + enquiry.getPostcode() + " \n" +
                "Type of project: " + enquiry.getProjectType() + " \n" +
                "Project description: " + enquiry.getProjectDescription() + " \n");
        Enquiry enquiryEntity = new Enquiry();
        enquiryEntity.setName(enquiry.getName());
        enquiryEntity.setEmail(enquiry.getEmail());
        enquiryEntity.setPhone(enquiry.getPhone());
        enquiryEntity.setPostcode(enquiry.getPostcode());
        enquiryEntity.setProjectType(enquiry.getProjectType());
        enquiryEntity.setProjectDescription(enquiry.getProjectDescription());

        repository.save(enquiryEntity);

        try {
            mailSender.send(message);
//            System.out.println("got here");
            // return successful mail response
            return new StatusResponse("SUCCESS", "Successfully sent email");
        } catch (MailException e) {
            System.out.println("MAIL ERROR: " + e.getMessage());
            return new StatusResponse("ERROR", "Could not send email");
            // return failed mail response
        }
    }
}
