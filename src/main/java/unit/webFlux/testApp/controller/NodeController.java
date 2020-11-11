package unit.webFlux.testApp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unit.webFlux.testApp.dto.NodeDescDTO;
import unit.webFlux.testApp.dto.NodeRootDTO;
import unit.webFlux.testApp.persistence.model.Node;
import unit.webFlux.testApp.service.NodeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/nodes")
public class NodeController {

    private final NodeService nodeService;

    @PostMapping
    public ResponseEntity saveNodeWithDesc(@RequestBody final NodeDescDTO nodeDescDTO) {
        nodeService.create(nodeDescDTO.createNode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping
    public ResponseEntity saveNodeWithoutDesc(@RequestBody final NodeRootDTO nodeRootDTO) {
        nodeService.create(nodeRootDTO.createNode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public List<Node> getAllNodes() {
        return nodeService.findAll();
    }

}
