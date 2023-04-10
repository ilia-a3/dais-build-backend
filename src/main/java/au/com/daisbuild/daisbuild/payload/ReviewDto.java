package au.com.daisbuild.daisbuild.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {
    private String title;
    private String author;
    private String body;
    private String stars;
    private String date;
}
