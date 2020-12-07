package com.lambdaschool.orders.repositories;

import org.springframework.data.repository.CrudRepository;
import com.lambdaschool.orders.models.Agent;

public interface AgentRepository extends CrudRepository<Agent, Long> {
}
