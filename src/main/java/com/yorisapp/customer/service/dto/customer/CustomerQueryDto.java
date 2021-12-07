package com.yorisapp.customer.service.dto.customer;

import lombok.Data;

@Data
public class CustomerQueryDto {
    private long id;
    private String name;
    private String phone;
    private String state;
}
