package com.veterinary_clinic.veterinary_clinic.procedures;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/procedures")
public class ProceduresController {
    private final ProceduresService proceduresService;
    @GetMapping
    public List<ProceduresDto> findAll(){
        System.out.println("yes");
        return proceduresService.findAll();
    }
}
