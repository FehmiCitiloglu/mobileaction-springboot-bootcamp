package com.fehmi.mobileaction.mobileactionbootcamp.gen.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel, Serializable, Cloneable {

    private static final Long serialVersionUID = 1L;

    @Embedded
    private BaseAdditionalFields baseAdditionalFields;
}
