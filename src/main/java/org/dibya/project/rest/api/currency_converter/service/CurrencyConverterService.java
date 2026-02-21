package org.dibya.project.rest.api.currency_converter.service;

import org.dibya.project.rest.api.currency_converter.dto.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public interface CurrencyConverterService {
    public SupportedCodesResponse getSupportedCodes();
    public ConversionRateResponse getConversionRates(ConversionRateRequest conversionRateRequest);
    public PairConversionResponse getPairConversionRates(PairConversionRequest pairConversionRequest);
    public CurrencyHistoryResponse getCurrencyHistory(CurrencyHistoryRequest request);
}
