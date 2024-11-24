package com.almosafer.paymentrules.mapper;

import com.almosafer.paymentrules.dto.PaymentRuleDto;
import com.almosafer.paymentrules.entity.PaymentRule;
import org.springframework.stereotype.Component;

@Component
public class PaymentRuleMapper {
    public static PaymentRuleDto toPaymentRuleDto(PaymentRule paymentRule){
        return PaymentRuleDto
                .builder()
                .id(paymentRule.getId())
                .title(paymentRule.getTitle())
                .paymentMethods(paymentRule.getPaymentMethods())
                .currency(paymentRule.getCurrency())
                .appIds(paymentRule.getAppIds())
                .conditions(paymentRule.getConditions())
                .processing(paymentRule.getProcessing())
                .priority(paymentRule.getPriority())
                .isActive(paymentRule.getIsActive())
                .createdAt(paymentRule.getCreatedAt())
                .updatedAt(paymentRule.getUpdatedAt())
                .build();
    }
    public static PaymentRule toPaymentRule(PaymentRuleDto paymentRuleDto){
       return PaymentRule
                .builder()
                   .id(paymentRuleDto.getId())
                   .title(paymentRuleDto.getTitle())
                   .paymentMethods(paymentRuleDto.getPaymentMethods())
                   .currency(paymentRuleDto.getCurrency())
                   .appIds(paymentRuleDto.getAppIds())
                   .conditions(paymentRuleDto.getConditions())
                   .processing(paymentRuleDto.getProcessing())
                   .priority(paymentRuleDto.getPriority())
                   .isActive(paymentRuleDto.getIsActive())
                //   .createdAt(paymentRuleDto.getCreatedAt())
                //   .updatedAt(paymentRuleDto.getUpdatedAt())
                .build();
    }
}
