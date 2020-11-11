package unit.webFlux.testApp.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import unit.webFlux.testApp.persistence.model.Node;

public interface NodeRepository extends MongoRepository<Node, String> {
}
