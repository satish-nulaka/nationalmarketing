package com.nationalmarketing.controller;

import com.nationalmarketing.entity.SalesLead;
import com.nationalmarketing.service.SalesLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/sales-lead")
public class SalesLeadController {

    @Autowired
    private SalesLeadService salesLeadService;

    @GetMapping
    public String getAllSalesLeads(Model model) {
        List<SalesLead> salesLeads = salesLeadService.getAllSalesLeads();
        model.addAttribute("salesLeads", salesLeads);
        return "sales-lead-list";
    }

    @GetMapping("/add")
    public String showAddSalesLeadForm(Model model) {
        model.addAttribute("salesLead", new SalesLead());
        model.addAttribute("statuses", SalesLead.Status.values());
        return "add-sales-lead";
    }

    @PostMapping("/add")
    public String addSalesLead(@ModelAttribute SalesLead salesLead) {
        salesLeadService.addSalesLead(salesLead);
        return "redirect:/sales-lead";
    }

    @GetMapping("/delete/{id}")
    public String deleteSalesLead(@PathVariable Long id) {
        salesLeadService.deleteSalesLead(id);
        return "redirect:/sales-lead";
    }

    @GetMapping("/edit/{id}")
    public String editSalesLead(@PathVariable Long id, Model model) {
        SalesLead salesLead = salesLeadService.findById(id);
        model.addAttribute("salesLead", salesLead);
        model.addAttribute("statuses", SalesLead.Status.values());
        return "edit-sales-lead";
    }

    @PostMapping("/edit/{id}")
    public String updateSalesLead(@PathVariable Long id, SalesLead salesLead) {
        salesLead.setId(id);
        salesLeadService.save(salesLead);
        return "redirect:/sales-lead";
    }
}