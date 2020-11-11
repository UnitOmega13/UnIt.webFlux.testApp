package unit.webFlux.testApp.dto;

import lombok.*;
import unit.webFlux.testApp.persistence.model.Node;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NodeDescDTO{
    private String id;
    private String name;
    private String description;

    public Node createNode(){
        return Node.builder()
                .name(this.name)
                .description(this.description)
                .build();
    }
}
