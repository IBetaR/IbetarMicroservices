package com.ibetar.fraud.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class FraudCheckHistory {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "fraud_id_seq")
    @SequenceGenerator(
            name = "fraud_id_seq",
            sequenceName = "fraud_id_seq")
    private Integer id;
    private Integer customerId;
    private boolean isFraudster;
    private LocalDateTime createdAt;
}
