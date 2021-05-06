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

    @RequestMapping(value="",method = RequestMethod.GET  )
    @ResponseBody
    public Objects getLikes(@RequestParam(defaultValue="b2b810de148a48a51ddd54ae124389c6831ec3bc")String id )  {
        return objectService.listOne(id);
    }


    @RequestMapping(value="",method = RequestMethod.POST )
    @ResponseBody
    public Objects updateLikes(@RequestParam(defaultValue="b2b810de148a48a51ddd54ae124389c6831ec3bc")String id, Objects newobject )  {
        Objects object = objectService.listOne(id);
        object.setLikes(newobject.getLikes());
        objectService.save(object);


        return objectService.listOne(id);
    }

}
