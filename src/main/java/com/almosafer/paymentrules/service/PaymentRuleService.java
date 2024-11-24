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

    public Mono<PaymentRuleDto> updatePaymentRule(Mono<PaymentRuleDto> paymentRuleDtoMono, String id){
        return paymentRuleRepository.findById(id) // getting record from DB which is Mono<PaymentRule>
                        .flatMap(dbRule -> paymentRuleDtoMono.map(PaymentRuleMapper::toPaymentRule) // get the request object and convert into entity
                        .doOnNext(updatedRule -> {
                            updatedRule.setId(id);
                            updatedRule.setCreatedAt(dbRule.getCreatedAt());
                        })
                        .flatMap(paymentRuleRepository::save)
                        .map(PaymentRuleMapper::toPaymentRuleDto));

    }
    public Mono<Void> deletePaymentRule(String id) {
        return paymentRuleRepository.findById(id)
                .flatMap(rule -> paymentRuleRepository.delete(rule).then())
                .switchIfEmpty(Mono.empty());
    }


}
