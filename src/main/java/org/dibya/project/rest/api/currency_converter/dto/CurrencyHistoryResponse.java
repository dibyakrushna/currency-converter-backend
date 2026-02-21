package org.dibya.project.rest.api.currency_converter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Map;

@Data
public class CurrencyHistoryResponse {
    private String result ;
    @JsonProperty(value = "base_code")
    private String baseCode;
    @JsonProperty(value = "requested_amount")
    private BigDecimal requestedAmount ;
    @JsonProperty(value = "year")
    private Integer year ;
    @JsonProperty(value = "month")
    private Integer month ;
    @JsonProperty(value = "day")
    private Integer day ;
    @JsonProperty(value = "conversion_amounts")
    private Map<String, BigDecimal> conversionAmounts ;
}
