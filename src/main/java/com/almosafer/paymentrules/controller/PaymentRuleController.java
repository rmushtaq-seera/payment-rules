package com.almosafer.paymentrules.controller;

import com.almosafer.paymentrules.dto.PaymentRuleDto;
import com.almosafer.paymentrules.dto.PaymentRuleFilterDto;
import com.almosafer.paymentrules.service.PaymentRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
@RequestMapping(value = "/payment-rules")
@RequiredArgsConstructor
public class PaymentRuleController {
    private final PaymentRuleService paymentRuleService;

    @GetMapping
    public Mono<ResponseEntity<Flux<PaymentRuleDto>>> getPaymentRules(
            @RequestParam(required = false) String paymentMethod,
            @RequestParam(required = false) Integer appId,
            @RequestParam(required = false) String currency,
            @RequestParam(required = false) String provider,
            @RequestParam(required = false) String scheme,
            @RequestParam(required = false) String localScheme) {
        PaymentRuleFilterDto filterDto  = PaymentRuleFilterDto.builder()
                .paymentMethod(paymentMethod)
                .appId(appId)
                .currency(currency)
                .provider(provider)
                .scheme(scheme)
                .localScheme(localScheme)
                .build();
        Flux<PaymentRuleDto> paymentRulesFlux = paymentRuleService.getPaymentRules(filterDto);
        return paymentRulesFlux.hasElements()
                .flatMap(hasElements -> {
                    if(hasElements){
                        return Mono.just(ResponseEntity.ok(paymentRulesFlux));
                    }else{
                        return Mono.just(ResponseEntity.notFound().build());
                    }
                });
    }
    @PostMapping
    public Mono<ResponseEntity<PaymentRuleDto>> addPaymentRule(@RequestBody Mono<PaymentRuleDto> paymentRuleDto){
        return paymentRuleService.addPaymentRule(paymentRuleDto)
                .map(addedRule -> ResponseEntity.created(URI.create("/payment-rules/" +addedRule.getId())).body(addedRule))
                .switchIfEmpty(Mono.just(ResponseEntity.internalServerError().build()));
    }
    @PatchMapping("/{id}")
    public Mono<ResponseEntity<PaymentRuleDto>> updatePaymentRule(@RequestBody Mono<PaymentRuleDto> paymentRuleDto, @PathVariable String id){
        return paymentRuleService.updatePaymentRule(paymentRuleDto, id)
                .map(paymentRule -> ResponseEntity.ok(paymentRule))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePaymentRule(@PathVariable String id){
        return paymentRuleService.deletePaymentRule(id)
                .then(Mono.just(ResponseEntity.noContent().<Void>build()))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));

    }



   /* @PutMapping("/update/{id}")
    public PaymentRuleDto updatePaymentRule(@RequestBody PaymentRuleDto paymentRuleDto, @PathVariable String id){
        return paymentRuleService.updatePaymentRuleByLegacy(paymentRuleDto, id);
    }*/
    }
