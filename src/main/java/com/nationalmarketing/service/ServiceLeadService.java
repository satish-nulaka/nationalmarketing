package com.nationalmarketing.service;

import com.nationalmarketing.entity.SalesLead;
import com.nationalmarketing.entity.ServiceLead;
import com.nationalmarketing.repository.ServiceLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceLeadService {

    @Autowired
    private ServiceLeadRepository serviceLeadRepository;

    public ServiceLead addServiceLead(ServiceLead serviceLead) {
        return serviceLeadRepository.save(serviceLead);
    }

    public List<ServiceLead> getAllServiceLeads() {
        return serviceLeadRepository.findAll();
    }

    public void deleteServiceLead(Long id) {
        serviceLeadRepository.deleteById(id);
    }

    public ServiceLead findById(Long id) {
        return serviceLeadRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid sales lead ID"));
    }

    public void save(ServiceLead serviceLead) {
        serviceLeadRepository.save(serviceLead);
    }
}