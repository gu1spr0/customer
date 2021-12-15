package com.yorisapp.customer.model.entity;

import com.yorisapp.customer.model.entity.base.BaseConfigurationEntity;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "cu_customer")
public class Customer extends BaseConfigurationEntity {
    @NotNull (message = "El nombre completo no puede ser nulo")
    @Column(name = "name", length = 60)
    private String name;

    @NotNull (message = "El el número de teléfono/celular no puede ser nulo")
    @Column(name = "phone", length = 12)
    private String phone;
}
