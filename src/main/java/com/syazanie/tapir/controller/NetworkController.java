package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.Operator;
import com.syazanie.tapir.entity.Transit;
import com.syazanie.tapir.service.NetworkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/network")
public class NetworkController {

    private final NetworkService networkService;

    public NetworkController(NetworkService networkService) {
        this.networkService = networkService;
    }

    @PostMapping("/operators")
    public Operator createOperator(@RequestBody Operator operator) { return networkService.createOperator(operator); }

    @GetMapping("/operators")
    public List<Operator> getOperators() { return networkService.getAllOperators(); }

    @PostMapping("/transits")
    public Transit createTransit(@RequestBody Transit transit) { return networkService.createTransit(transit); }

    @GetMapping("/transits")
    public List<Transit> getTransits() { return networkService.getAllTransits(); }
}