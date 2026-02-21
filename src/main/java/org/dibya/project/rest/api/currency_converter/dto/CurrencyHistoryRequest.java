package org.dibya.project.rest.api.currency_converter.dto;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

@Data
public class CurrencyHistoryRequest {
    private String code;
    private Integer year;
    private Integer month;
    private Integer day;
    private BigDecimal amount;
}
