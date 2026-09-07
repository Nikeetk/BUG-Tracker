package org.example.project.repository;

import org.example.project.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByProjectId(Long projectId);

    List<Ticket> findByAssignedToId(Long userId);
}