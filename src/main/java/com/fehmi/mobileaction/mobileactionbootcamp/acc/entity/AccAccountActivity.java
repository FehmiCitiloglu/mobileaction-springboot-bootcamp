package com.fehmi.mobileaction.mobileactionbootcamp.acc.entity;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccAccountActivityType;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "ACC_ACCOUNT_ACTIVITY")
@Data
public class AccAccountActivity extends BaseEntity {
    @Id
    @SequenceGenerator(name="AccAccountActivity", sequenceName = "ACC_ACCOUNT_ID_ACTIVITY")
    @GeneratedValue(generator = "AccAccountActivity")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ID_ACC_ACCOUNT")
    private AccAccount accAccount;

    @Column(name ="AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @Column(name = "TRANSACTION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @Enumerated(EnumType.STRING)
    @Column(name ="ACCCOUNT_ACTIVITY_TYPE", length = 30)
    private EnumAccAccountActivityType accountActivityType;
}
