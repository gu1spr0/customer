package com.yorisapp.customer.service.impl;

import com.google.common.base.Strings;
import com.yorisapp.customer.exception.Message;
import com.yorisapp.customer.exception.MessageDescription;
import com.yorisapp.customer.model.entity.Customer;
import com.yorisapp.customer.model.repository.CustomerRepository;
import com.yorisapp.customer.service.CustomerService;
import com.yorisapp.customer.service.dto.customer.CustomerAddDto;
import com.yorisapp.customer.service.dto.customer.CustomerQueryDto;
import com.yorisapp.customer.service.dto.customer.CustomerQueryPageableDto;
import com.yorisapp.customer.service.dto.customer.CustomerUpdateDto;
import com.yorisapp.customer.util.Constants;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @Override
    public CustomerQueryPageableDto getCustomersPageable(String pState, int pPage, int pRowsNumber) {
        CustomerQueryPageableDto vCustomerQueryPageableDto = new CustomerQueryPageableDto();
        List<CustomerQueryDto> vCustomerQueryDtoList = new ArrayList<>();
        if(Strings.isNullOrEmpty(pState)){
            throw Message.GetBadRequest(MessageDescription.stateNullOrEmpty);
        }
        if(!(pState.equals(Constants.STATE_ACTIVE) || pState.equals(Constants.STATE_INACTIVE) || pState.equals(Constants.STATE_BLOCKED) || pState.equals(Constants.STATE_DELETED))){
            Object[] obj = {pState};
            throw Message.GetBadRequest(MessageDescription.stateNotValid, obj);
        }
        long vTotalRows = customerRepository.getCountCustomersByState(pState);
        if (vTotalRows>0){
            List<Customer> vCustomerList = customerRepository.getCustomersPageableByState(pState, PageRequest.of(pPage, pRowsNumber));
            for(Customer vCustomer: vCustomerList){
                CustomerQueryDto vCustomerQueryDto = new CustomerQueryDto();
                BeanUtils.copyProperties(vCustomer, vCustomerQueryDto);
                vCustomerQueryDtoList.add(vCustomerQueryDto);
            }
            vCustomerQueryPageableDto.setTotalRows(vTotalRows);
            vCustomerQueryPageableDto.setCustomerQueryDtoList(vCustomerQueryDtoList);
        }else{
            vCustomerQueryPageableDto.setTotalRows(0);

        }
        return vCustomerQueryPageableDto;
    }

    @Override
    public CustomerQueryDto addCustomer(CustomerAddDto pCustomerAddDto) {
        Customer vCustomer = new Customer();
        Customer vResponse = new Customer();
        BeanUtils.copyProperties(pCustomerAddDto, vCustomer);
        vResponse = this.customerRepository.save(vCustomer);
        if(vResponse == null){
            throw Message.GetBadRequest(MessageDescription.notInsert);
        }
        CustomerQueryDto vCustomerQueryDto = new CustomerQueryDto();
        BeanUtils.copyProperties(vResponse, vCustomerQueryDto);
        return vCustomerQueryDto;
    }

    @Override
    public CustomerQueryDto updateCustomer(long pCustomerId, CustomerUpdateDto pCustomerUpdateDto) {
        return null;
    }

    @Override
    public void deleteCustomer(long pCustomerId) {

    }
}
