package au.com.daisbuild.daisbuild.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class StatusResponse {
    private String status;
    private String message;
    private String timestamp;

    public StatusResponse(String status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date().toString();
    }
}
