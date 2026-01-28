package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.Operator;
import com.syazanie.tapir.entity.Transit;
import com.syazanie.tapir.repository.OperatorRepository;
import com.syazanie.tapir.repository.TransitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NetworkService {

    private final OperatorRepository operatorRepository;
    private final TransitRepository transitRepository;

    public NetworkService(OperatorRepository operatorRepository, TransitRepository transitRepository) {
        this.operatorRepository = operatorRepository;
        this.transitRepository = transitRepository;
    }

    // Operator Logic
    public Operator createOperator(Operator operator) { return operatorRepository.save(operator); }
    public List<Operator> getAllOperators() { return operatorRepository.findAll(); }

    // Transit Logic
    public Transit createTransit(Transit transit) { return transitRepository.save(transit); }
    public List<Transit> getAllTransits() { return transitRepository.findAll(); }
}