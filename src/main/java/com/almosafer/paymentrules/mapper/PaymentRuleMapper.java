package com.almosafer.paymentrules.mapper;

import com.almosafer.paymentrules.dto.PaymentRuleDto;
import com.almosafer.paymentrules.entity.PaymentRule;
import com.almosafer.paymentrules.utils.CommonUtils;
import org.springframework.stereotype.Component;

@Component
public class PaymentRuleMapper {
    public static PaymentRuleDto toPaymentRuleDto(PaymentRule paymentRule){
        return PaymentRuleDto
                .builder()
                .id(paymentRule.getId())
                .title(paymentRule.getTitle())
                .description(paymentRule.getDescription())
                .paymentMethods(paymentRule.getPaymentMethods())
                .currency(paymentRule.getCurrency())
                .appIds(paymentRule.getAppIds())
                .match(paymentRule.getMatch())
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
                   .description(paymentRuleDto.getDescription())
                   .paymentMethods(paymentRuleDto.getPaymentMethods())
                   .currency(paymentRuleDto.getCurrency())
                   .appIds(paymentRuleDto.getAppIds())
                   .match(paymentRuleDto.getMatch())
                   .conditions(paymentRuleDto.getConditions())
                   .processing(paymentRuleDto.getProcessing())
                   .priority(paymentRuleDto.getPriority())
                   .isActive(paymentRuleDto.getIsActive())
                .build();
    }
    public static PaymentRule toUpdateModel(final PaymentRule paymentRule, PaymentRuleDto paymentRuleDto){
        if (!CommonUtils.isNullOrEmptyString(paymentRuleDto.getTitle())) {
            paymentRule.setTitle(paymentRuleDto.getTitle());
        }
        if (!CommonUtils.isNullOrEmptyString(paymentRuleDto.getDescription())) {
            paymentRule.setDescription(paymentRuleDto.getDescription());
        }
        if (!CommonUtils.isNullOrEmpty(paymentRuleDto.getPaymentMethods())) {
            paymentRule.setPaymentMethods(paymentRuleDto.getPaymentMethods());
        }
        if (!CommonUtils.isNullOrEmptyString(paymentRuleDto.getCurrency())) {
            paymentRule.setCurrency(paymentRuleDto.getCurrency());
        }
        if (!CommonUtils.isNullOrEmpty(paymentRuleDto.getAppIds())) {
            paymentRule.setAppIds(paymentRuleDto.getAppIds());
        }
        if (!CommonUtils.isNullOrEmptyString(paymentRuleDto.getMatch())) {
            paymentRule.setMatch(paymentRuleDto.getMatch());
        }
        if (!CommonUtils.isNullOrEmpty(paymentRuleDto.getConditions())) {
            paymentRule.setConditions(paymentRuleDto.getConditions());
        }
        if (!CommonUtils.isNull(paymentRuleDto.getProcessing())) {
            paymentRule.setProcessing(paymentRuleDto.getProcessing());
        }
        if (!CommonUtils.isNull(paymentRuleDto.getPriority())) {
            paymentRule.setProcessing(paymentRuleDto.getPriority());
        }
        if (!CommonUtils.isNull(paymentRuleDto.getIsActive())) {
            paymentRule.setIsActive(paymentRuleDto.getIsActive());
        }
        return paymentRule;
    }
}
