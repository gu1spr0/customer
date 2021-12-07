package com.yorisapp.customer.service;

import com.yorisapp.customer.service.dto.customer.CustomerAddDto;
import com.yorisapp.customer.service.dto.customer.CustomerQueryDto;
import com.yorisapp.customer.service.dto.customer.CustomerQueryPageableDto;
import com.yorisapp.customer.service.dto.customer.CustomerUpdateDto;

public interface CustomerService {
    CustomerQueryPageableDto getCustomersPageable(String pState, int pPage, int pRowsNumber);
    CustomerQueryDto addCustomer(CustomerAddDto pCustomerAddDto);
    CustomerQueryDto updateCustomer(long pCustomerId, CustomerUpdateDto pCustomerUpdateDto);
    void deleteCustomer(long pCustomerId);
}
