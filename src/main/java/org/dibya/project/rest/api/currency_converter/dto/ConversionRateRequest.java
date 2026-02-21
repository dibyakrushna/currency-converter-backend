package org.dibya.project.rest.api.currency_converter.dto;

import jakarta.validation.constraints.NotEmpty;

public record ConversionRateRequest(
      @NotEmpty String code
) {
}
