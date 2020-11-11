package unit.webFlux.testApp.dto;

import lombok.*;
import unit.webFlux.testApp.persistence.model.Node;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NodeRootDTO {
    private String id;
    private String name;

    public Node createNode(){
        return Node.builder()
                .name(this.name)
                .build();
    }
}
