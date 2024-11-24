package com.almosafer.paymentrules.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PaymentRuleFilterDto {
    String paymentMethod;
    Integer appId;
    String currency;
    String scheme;
    String localScheme;
    String provider;
}
