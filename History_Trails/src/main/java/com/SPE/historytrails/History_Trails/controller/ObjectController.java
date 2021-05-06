package com.SPE.historytrails.History_Trails.controller;

import com.SPE.historytrails.History_Trails.domain.Objects;
import com.SPE.historytrails.History_Trails.service.ObjectService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/objects")
public class ObjectController {

    private ObjectService objectService;

    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping("/list")
    public Iterable<Objects> list() {
        return objectService.list();
    }



}
