package org.dibya.project.rest.api.currency_converter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class SupportedCodesResponse {
    private String result;
//    private String documentation;
//    @JsonProperty("terms_of_use")
//    private String termsOfUse;
    @JsonProperty("supported_codes")
    private List<List<String>> SupportedCodes;
}
