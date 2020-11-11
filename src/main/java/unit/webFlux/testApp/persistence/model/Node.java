package unit.webFlux.testApp.persistence.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "nodes")
@Builder
@Getter
@Setter
public class Node {
    @Id
    @Field(name = "id")
    public String id;

    @Field(name = "name")
    public String name;

    @Field(name = "description")
    public String description;
}
