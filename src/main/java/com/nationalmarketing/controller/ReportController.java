package com.nationalmarketing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    @GetMapping("/reports/edit/sales")
    public String editSalesReport() {
        return "sales-lead-list"; // This should map to a template named 'editSalesReport.html'
    }

    @GetMapping("/reports/edit/service")
    public String editServiceReport() {
        return "service-lead-list"; // This should map to a template named 'editServiceReport.html'
    }

    @GetMapping("/reports/filters")
    public String reportWithFilters() {
        return "reportWithFilters"; // This should map to a template named 'reportWithFilters.html'
    }
}