package com.practice.microservices.currencyexchangeservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to
    ){
//         CurrencyExchange currencyExchange = new CurrencyExchange(1000L,
//                from, to,
//                new BigDecimal(70));

        CurrencyExchange currencyExchange = this.currencyRepository.findByFromAndTo(from, to);

        if (currencyExchange == null){
            throw new RuntimeException("No match found..");
        }
         currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
         return currencyExchange;

    }


}
