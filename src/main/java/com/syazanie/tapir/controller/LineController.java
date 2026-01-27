package com.syazanie.tapir.controller;

import com.syazanie.tapir.entity.Line;
import com.syazanie.tapir.service.LineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lines") // URL: http://localhost:8080/api/lines
public class LineController {

    private final LineService lineService;

    public LineController(LineService lineService) {
        this.lineService = lineService;
    }

    @PostMapping
    public Line create(@RequestBody Line line) {
        return lineService.createLine(line);
    }

    @GetMapping
    public List<Line> getAll() {
        return lineService.getAllLines();
    }
}