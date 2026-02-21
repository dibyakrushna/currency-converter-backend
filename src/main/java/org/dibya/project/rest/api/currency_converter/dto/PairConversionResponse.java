package org.dibya.project.rest.api.currency_converter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class PairConversionResponse {
    private String result ;
    @JsonProperty(value = "time_last_update_utc")
    private  String timeLastUpdateUtc;
    @JsonProperty(value = "time_next_update_utc")
    private String timeNextUpdateUtc;
    @JsonProperty(value = "base_code")
    private String baseCode;
    @JsonProperty(value = "conversion_rate")
    private BigDecimal conversionRates ;
    @JsonProperty(value = "target_code")
    private String targetCode ;
    @JsonProperty(value = "conversion_result")
    private BigDecimal conversionResult ;
}
