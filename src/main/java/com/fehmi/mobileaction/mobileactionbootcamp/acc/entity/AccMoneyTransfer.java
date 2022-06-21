package com.fehmi.mobileaction.mobileactionbootcamp.acc.entity;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccMoneyTransferType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table
@Getter
@Setter
public class AccMoneyTransfer {
    @Id
    @SequenceGenerator(name = "AccMoneyTransfer", sequenceName = "ACC_MONEY_TRANSFER_ID_SEQ")
    @GeneratedValue(generator = "AccMoneyTransfer")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ACC_ACCOUNT_FROM")
    private AccAccount accAccountFrom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ACC_ACCOUNT_TO")
    private AccAccount accAccountTo;

    @Column(name = "AMOUNT", precision = 19, scale = 2)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSFER_DATE")
    private Date transferDate;

    @Column(name = "DESCRPTION", length = 100)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "MONEY_TRANSFER_TYPE", length = 30)
    private EnumAccMoneyTransferType moneyTransferType;

}
