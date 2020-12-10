package com.lambdaschool.javaorders.services;

import com.lambdaschool.javaorders.models.Agent;

public interface AgentServices {
    Agent findAgentById(long agentcode);

    Agent save(Agent agent);

    void deleteAllAgents();
}
