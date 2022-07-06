package test.mingorance.istio.springservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ApplicationService {

    @Value("${application.id}")
    private String applicationId;

    public String getApplicationId() {
        if (this.applicationId == null) {
            this.applicationId = UUID.randomUUID().toString();
        }
        return this.applicationId;
    }

}
