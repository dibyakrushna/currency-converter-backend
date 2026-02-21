package org.dibya.project.rest.api.currency_converter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Component
@Data
public class ConversionRateResponse {
    private String result ;
    @JsonProperty(value = "time_last_update_utc")
    private  String timeLastUpdateUtc;
    @JsonProperty(value = "time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonProperty(value = "base_code")
    private String baseCode;
    @JsonProperty(value = "conversion_rates")
    private Map<String, BigDecimal> conversionRates ;
}
