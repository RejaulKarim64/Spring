package com.emranhss.project.restcontroller;


import com.emranhss.project.entity.PoliceStation;
import com.emranhss.project.service.PoliceStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policestation/")
public class PoliceStationRestController {

    @Autowired
    private PoliceStationService policeStationService;

    @PostMapping("")
    public void save(@RequestBody PoliceStation ps) {
        policeStationService.saveOrUpdate(ps);
    }
    @GetMapping("")
    public List<PoliceStation> getAll(){
        return  policeStationService.findAll();
    }
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable Integer id){
        policeStationService.deleteById(id);
    }
    @PutMapping("{id}")
    public  void update(@RequestBody PoliceStation ps){
        policeStationService.saveOrUpdate(ps);
    }
}
