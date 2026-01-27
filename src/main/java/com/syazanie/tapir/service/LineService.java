package com.syazanie.tapir.service;

import com.syazanie.tapir.entity.Line;
import com.syazanie.tapir.repository.LineRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineService {

    private final LineRepository lineRepository;

    public LineService(LineRepository lineRepository) {
        this.lineRepository = lineRepository;
    }

    // 1. Create a new Line (e.g., "Kajang Line")
    public Line createLine(Line line) {
        return lineRepository.save(line);
    }

    // 2. Get all Lines (For the Frontend Map)
    public List<Line> getAllLines() {
        return lineRepository.findAll();
    }
}