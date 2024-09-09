package com.nationalmarketing.controller;

import com.nationalmarketing.entity.SalesLead;
import com.nationalmarketing.entity.ServiceLead;
import com.nationalmarketing.service.ServiceLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service-lead")
public class ServiceLeadController {

    @Autowired
    private ServiceLeadService serviceLeadService;

    @GetMapping
    public String getAllServiceLeads(Model model) {
        List<ServiceLead> serviceLeads = serviceLeadService.getAllServiceLeads();
        model.addAttribute("serviceLeads", serviceLeads);
        return "service-lead-list";
    }

    @GetMapping("/add")
    public String showAddServiceLeadForm(Model model) {
        model.addAttribute("serviceLead", new ServiceLead());
        model.addAttribute("statuses", ServiceLead.Status.values());
        return "add-service-lead";
    }

    @PostMapping("/add")
    public String addServiceLead(@ModelAttribute ServiceLead serviceLead) {
        serviceLeadService.addServiceLead(serviceLead);
        return "redirect:/service-lead";
    }

    @GetMapping("/delete/{id}")
    public String deleteServiceLead(@PathVariable Long id) {
        serviceLeadService.deleteServiceLead(id);
        return "redirect:/service-lead";
    }

    @GetMapping("/edit/{id}")
    public String editServiceLead(@PathVariable Long id, Model model) {
        ServiceLead serviceLead = serviceLeadService.findById(id);
        System.out.println("===================="+serviceLead.getStatus());
        model.addAttribute("serviceLead", serviceLead);
        model.addAttribute("statuses", ServiceLead.Status.values());
        return "edit-service-lead";
    }

    @PostMapping("/edit/{id}")
    public String updateSalesLead(@PathVariable Long id,  ServiceLead serviceLead) {
        serviceLead.setId(id);
        serviceLeadService.save(serviceLead);
        return "redirect:/service-lead";
    }
}