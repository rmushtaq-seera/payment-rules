package com.almosafer.paymentrules.repository;

import com.almosafer.paymentrules.entity.PaymentRule;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRuleRepository extends ReactiveMongoRepository<PaymentRule, String>, PaymentRuleCustomRepository {
}
