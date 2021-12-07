package com.yorisapp.customer.controller;

import com.yorisapp.customer.service.CustomerService;
import com.yorisapp.customer.service.dto.customer.CustomerAddDto;
import com.yorisapp.customer.service.dto.customer.CustomerQueryDto;
import com.yorisapp.customer.service.dto.customer.CustomerQueryPageableDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(description = "Endpoint para la gestión de clientes")
@RestController
@RequestMapping("users")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }
    @ApiOperation(value = "Obtiene un listado de usuarios paginado por estado")
    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    public CustomerQueryPageableDto getCustomerPageable(@ApiParam(value = "Estado del cliente a filtrar") @RequestParam String state,
                                                                      @ApiParam(value = "Número de página a consultar") @RequestParam int page,
                                                                      @ApiParam(value = "Número de registros a consultar") @RequestParam int rowsNumber){
        return this.customerService.getCustomersPageable(state, page, rowsNumber);
    }

    @ApiOperation(value = "Crea un usuario")
    @PostMapping(path = "")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerQueryDto addCustomer(@ApiParam(value = "Datos del usuario") @Valid @RequestBody CustomerAddDto pCustomerAddDto){
        return this.customerService.addCustomer(pCustomerAddDto);
    }

}
