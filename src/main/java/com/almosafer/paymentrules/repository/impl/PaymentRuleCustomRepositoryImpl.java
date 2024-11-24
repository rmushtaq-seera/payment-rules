package com.almosafer.paymentrules.repository.impl;

import com.almosafer.paymentrules.dto.PaymentRuleFilterDto;
import com.almosafer.paymentrules.entity.PaymentRule;
import com.almosafer.paymentrules.repository.PaymentRuleCustomRepository;
import com.almosafer.paymentrules.utils.CommonUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

 @Repository
@RequiredArgsConstructor
public class PaymentRuleCustomRepositoryImpl implements PaymentRuleCustomRepository {
    private final ReactiveMongoTemplate reactiveMongoTemplate;
    @Override
    public Flux<PaymentRule> findPaymentRulesByCriteria(PaymentRuleFilterDto paymentRuleFilterDto) {
        Criteria criteria = new Criteria();
        if(!CommonUtils.isNullOrEmptyString(paymentRuleFilterDto.getPaymentMethod())){
            criteria.and("paymentMethods").in(paymentRuleFilterDto.getPaymentMethod().toLowerCase());
        }
        if(!CommonUtils.isNull(paymentRuleFilterDto.getAppId())){
            criteria.and("appIds").in(paymentRuleFilterDto.getAppId());
        }
        if(!CommonUtils.isNull(paymentRuleFilterDto.getCurrency())){
            criteria.and("currency").is(paymentRuleFilterDto.getCurrency().toUpperCase());
        }
        if(!CommonUtils.isNullOrEmptyString(paymentRuleFilterDto.getProvider())){
            criteria.and("processing.provider").is(paymentRuleFilterDto.getProvider().toLowerCase());
        }
        if(!CommonUtils.isNullOrEmptyString(paymentRuleFilterDto.getScheme())){
            criteria.and("conditions.field").is("scheme").and("conditions.value").in(paymentRuleFilterDto.getScheme().toLowerCase());
        }
        if(!CommonUtils.isNullOrEmptyString(paymentRuleFilterDto.getLocalScheme())){
            criteria.and("conditions.field").is("localScheme").and("conditions.value").is(paymentRuleFilterDto.getLocalScheme().toLowerCase());
        }
        Query query = new Query(criteria);
        return reactiveMongoTemplate.find(query, PaymentRule.class);
    }
}
