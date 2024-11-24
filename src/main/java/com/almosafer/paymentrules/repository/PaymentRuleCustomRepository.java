package com.almosafer.paymentrules.repository;

import com.almosafer.paymentrules.dto.PaymentRuleFilterDto;
import com.almosafer.paymentrules.entity.PaymentRule;

import reactor.core.publisher.Flux;


public interface PaymentRuleCustomRepository {
   Flux<PaymentRule> findPaymentRulesByCriteria(PaymentRuleFilterDto paymentRuleFilterDto);
}
