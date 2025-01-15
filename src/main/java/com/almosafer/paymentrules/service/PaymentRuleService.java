package com.almosafer.paymentrules.service;

import com.almosafer.paymentrules.dto.PaymentRuleDto;
import com.almosafer.paymentrules.dto.PaymentRuleFilterDto;
import com.almosafer.paymentrules.mapper.PaymentRuleMapper;
import com.almosafer.paymentrules.repository.PaymentRuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PaymentRuleService {
    private final PaymentRuleRepository paymentRuleRepository;
    private final PaymentRuleMapper paymentRuleMapper;

    public Flux<PaymentRuleDto> getPaymentRules(PaymentRuleFilterDto paymentRuleFilterDto){
        return paymentRuleRepository.findPaymentRulesByCriteria(paymentRuleFilterDto).map(PaymentRuleMapper::toPaymentRuleDto);
    }
    public Mono<PaymentRuleDto> addPaymentRule(Mono<PaymentRuleDto> paymentRuleDtoMono){
        return paymentRuleDtoMono.map(PaymentRuleMapper::toPaymentRule)
                .flatMap(paymentRuleRepository::save)
                .map(PaymentRuleMapper::toPaymentRuleDto);
    }

    public Mono<PaymentRuleDto> updatePaymentRule(Mono<PaymentRuleDto> paymentRuleDtoMono, String ruleId){
        return paymentRuleDtoMono
                .flatMap(paymentRuleDto -> paymentRuleRepository.findById(ruleId)
                .map(dbRule -> paymentRuleMapper.toUpdateModel(dbRule, paymentRuleDto)) // get the request object and convert into entity
                .flatMap(paymentRuleRepository::save)
                .map(PaymentRuleMapper::toPaymentRuleDto));

    }

    public Mono<Void> deletePaymentRule(String ruleId) {
        return paymentRuleRepository.findById(ruleId)
                .flatMap(rule -> paymentRuleRepository.delete(rule).then())
                .switchIfEmpty(Mono.empty());
    }


}
