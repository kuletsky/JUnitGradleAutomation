package kuletsky.patterns.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Company {
    private String name;
    private String industry;
    private String country;
    private String city;
    private int numberOfEmployees;
}

