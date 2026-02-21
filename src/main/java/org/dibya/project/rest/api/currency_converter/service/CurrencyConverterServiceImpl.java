package org.dibya.project.rest.api.currency_converter.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.dibya.project.rest.api.currency_converter.dto.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service

@Data
public class CurrencyConverterServiceImpl implements CurrencyConverterService {
    private final RestTemplate restTemplate;



    public CurrencyConverterServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${app.exchangerate.api.key}")
    private  String apiKey;
    @Value("${app.exchangerate.baseUrl}")
    private  String baseUrl;
    @Override
    public SupportedCodesResponse getSupportedCodes() {
        return this.restTemplate.exchange(buildUrl("codes"), HttpMethod.GET, null, SupportedCodesResponse.class).getBody();
    }
    private String buildUrl(String endPoint) {
        String baseUrl = getBaseUrl();
        return baseUrl + "/" +  getApiKey()+ "/" + endPoint;
    }

    @Override
    public ConversionRateResponse getConversionRates(ConversionRateRequest conversionRateRequest) {
        String code = conversionRateRequest.code();
        return restTemplate.exchange(buildUrl("latest/"+code), HttpMethod.GET, null, ConversionRateResponse.class).getBody();
    }

    @Override
    public PairConversionResponse getPairConversionRates(PairConversionRequest pairConversionRequest) {
        String code = pairConversionRequest.code();
        String targetCode = pairConversionRequest.targetCode();
        BigDecimal amount =  pairConversionRequest.amount() ;
        return restTemplate.exchange(buildUrl("pair/"+code+"/"+targetCode+"/"+amount), HttpMethod.GET, null, PairConversionResponse.class).getBody();
    }

    @Override
    public CurrencyHistoryResponse getCurrencyHistory(CurrencyHistoryRequest request) {
        Integer year = request.getYear();
        Integer month = request.getMonth();
        Integer day = request.getDay();
        BigDecimal amount = request.getAmount();
        String code = request.getCode();
        return  restTemplate.exchange(buildUrl("history/"+"/"+ code + "/" + year + "/" + month + "/" + day + "/"+ amount), HttpMethod.GET, null,  CurrencyHistoryResponse.class ).getBody();
    }
}
