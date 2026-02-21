package org.dibya.project.rest.api.currency_converter.dto;

import jakarta.validation.constraints.NotEmpty;

import java.math.BigDecimal;

public record PairConversionRequest(
        @NotEmpty
        String code,
        @NotEmpty
        String targetCode,
        @NotEmpty
        BigDecimal amount
) {
}
