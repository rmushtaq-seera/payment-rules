package com.almosafer.paymentrules.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRuleDto {
    private String id;
    private String title;
    private List<String> paymentMethods;
    private String currency;
    private List<Integer> appIds;
    private List<Object> conditions;
    private Object processing;
    private Integer priority;
    private Boolean isActive;
    private Instant createdAt;
    private Instant updatedAt;
}
