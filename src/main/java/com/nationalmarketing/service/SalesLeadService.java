package com.nationalmarketing.service;

import com.nationalmarketing.entity.SalesLead;
import com.nationalmarketing.repository.SalesLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesLeadService {

    @Autowired
    private SalesLeadRepository salesLeadRepository;

    public SalesLead addSalesLead(SalesLead salesLead) {
        return salesLeadRepository.save(salesLead);
    }

    public List<SalesLead> getAllSalesLeads() {
        return salesLeadRepository.findAll();
    }

    public void deleteSalesLead(Long id) {
        salesLeadRepository.deleteById(id);
    }

    public SalesLead findById(Long id) {
        return salesLeadRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid sales lead ID"));
    }

    public void save(SalesLead salesLead) {
        salesLeadRepository.save(salesLead);
    }
}