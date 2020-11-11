package unit.webFlux.testApp.service;

import unit.webFlux.testApp.persistence.NodeRepository;
import unit.webFlux.testApp.persistence.model.Node;

import java.util.List;
import java.util.UUID;

public class NodeService{
    private NodeRepository nodeRepository;

    public Node create(Node node) {
        node.setId(UUID.randomUUID().toString());
        return nodeRepository.save(node);
    }

    public List<Node> findAll() {
        return nodeRepository.findAll();
    }
}
