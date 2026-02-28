package org.dibya.project.rest.api.currency_converter.controllers;

import jakarta.validation.Valid;
import lombok.Data;
import org.dibya.project.rest.api.currency_converter.dto.*;
import org.dibya.project.rest.api.currency_converter.service.CurrencyConverterService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/currencies")

@CrossOrigin("${app.exchangerate.frontendUrl}")
public class CurrencyConverterController {
    private final CurrencyConverterService currencyConverterService;

    public CurrencyConverterController(CurrencyConverterService currencyConverterService) {
        this.currencyConverterService = currencyConverterService;
    }

    @GetMapping("/codes")
    public ResponseEntity<SupportedCodesResponse>  getSupportedCodes() {
        return ResponseEntity.ok(currencyConverterService.getSupportedCodes());
    }

    /**
     * Choose your base currency and the Standard endpoint will
     * simply return the conversion rates from your
     * base currency code to all the others
     * we support in an easy to parse JSON format.
     */

    @PostMapping("/rates")
    public  ResponseEntity<?> getRates(@Valid @RequestBody ConversionRateRequest conversionRateRequest) {
        return ResponseEntity.ok(currencyConverterService.getConversionRates(conversionRateRequest));
    }
    /**
     * Our Pair Conversion API endpoint is useful
     * for applications where you just want
     * to convert between two specific currencies
     * and aren't interested in any others.
     */
    @PostMapping("/convert")
    public ResponseEntity<PairConversionResponse>  getPairConversion(
            @RequestBody PairConversionRequest pairConversionRequest
            ) {
        return ResponseEntity.ok(currencyConverterService.getPairConversionRates(pairConversionRequest));
    }
    /**
     * Our Historical Exchange
     * Rates API endpoint lets you
     * fetch all the exchange rate data
     * we have available for a specific day
     * in the past. It's only available
     * to users on our Pro,
     * Business or Volume plans.
     */
    @GetMapping("/currency-history")
    public ResponseEntity<CurrencyHistoryResponse>  getCurrencyHistory(@RequestBody CurrencyHistoryRequest request){
        return ResponseEntity.ok(currencyConverterService.getCurrencyHistory(request));
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        HashMap<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            errors.put(((FieldError)error).getField() , error.getDefaultMessage());
        });
        return  ResponseEntity.badRequest().body(errors);
    }
}
