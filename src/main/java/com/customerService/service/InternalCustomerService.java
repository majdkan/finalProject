package com.customerService.service;

import com.customerService.model.InternalCustomer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "InternalCustomerService",
        url = "${externalApi.customerService.url}"
)

public interface InternalCustomerService {
    @GetMapping(value = "/customer/{customerId}")
    InternalCustomer getInternalCustomerById(@PathVariable Long customerId);
}
