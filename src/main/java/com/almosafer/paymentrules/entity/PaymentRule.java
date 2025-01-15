package com.almosafer.paymentrules.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "payment_routing_rules")
public class PaymentRule {
    @Id
    private String id;
    private String title;
    private String description;
    private List<String> paymentMethods;
    private String currency;
    private List<Integer> appIds;
    private String match;
    private List<Object> conditions;
    private Object processing;
    private Integer priority;
    private Boolean isActive;
    @CreatedDate
    private Instant createdAt;
    @LastModifiedDate
    private Instant updatedAt;
}
