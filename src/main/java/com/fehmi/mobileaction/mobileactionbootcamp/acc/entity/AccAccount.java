package com.fehmi.mobileaction.mobileactionbootcamp.acc.entity;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccAccountType;
import com.fehmi.mobileaction.mobileactionbootcamp.acc.enums.EnumAccCurrencyType;
import com.fehmi.mobileaction.mobileactionbootcamp.cus.entity.CusCustomer;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.entity.BaseEntity;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.enums.EnumGenStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="ACC_ACCOUNT")
@Getter
@Setter
public class AccAccount extends BaseEntity {
    @Id
    @SequenceGenerator(name="AccAccount", sequenceName = "ACC_ACCOUNT_ID_SEQ")
    @GeneratedValue(generator = "AccAccount")
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CUS_CUSTOMER")
    private CusCustomer cusCustomer;

    @Column(name = "IBAN_NO", length = 30)
    private String ibanNo;

    @Column(name = "CURRENT_BALANCE", precision = 19, scale = 2)
    private BigDecimal currentBalance;

    @Column(name = "CURRENCY_TYPE", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumAccCurrencyType currencyType;

    @Column(name = "ACCOUNT_TYPE", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumAccAccountType accountType;

    @Column(name = "STATUS", length = 30)
    @Enumerated(EnumType.STRING)
    private EnumGenStatus status;

    @Column(name ="CANCEL_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cancelDate;

}

