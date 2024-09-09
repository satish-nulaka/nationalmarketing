package com.nationalmarketing.repository;

import com.nationalmarketing.entity.SalesLead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesLeadRepository extends JpaRepository<SalesLead, Long> {
}