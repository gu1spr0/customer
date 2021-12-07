package com.yorisapp.customer.service.dto.customer;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CustomerQueryPageableDto {
    private List<CustomerQueryDto> customerQueryDtoList;
    private long totalRows;
}
