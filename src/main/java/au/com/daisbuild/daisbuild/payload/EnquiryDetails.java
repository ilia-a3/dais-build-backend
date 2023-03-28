package au.com.daisbuild.daisbuild.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class EnquiryDetails {
    private String name;
    private String phone;
    private String email;
    private String postcode;
    private String projectType;
    private String projectDescription;

}
