package unit.webFlux.testApp;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import unit.webFlux.testApp.controller.NodeController;
import unit.webFlux.testApp.dto.NodeDescDTO;
import unit.webFlux.testApp.dto.NodeRootDTO;
import unit.webFlux.testApp.persistence.model.Node;
import unit.webFlux.testApp.service.NodeService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@WebMvcTest(NodeController.class)
class ApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private NodeService service;

	@Test
	void contextLoads() throws Exception {
		NodeRootDTO node = new NodeRootDTO();
		node.setName("firstNode");

		NodeDescDTO nodeSec = new NodeDescDTO();
		nodeSec.setName("secondNode");
		nodeSec.setDescription("Second Node");

		List<Node> allEmployees = Arrays.asList(node.createNode(), nodeSec.createNode());

		given(service.findAll()).willReturn(allEmployees);

		mockMvc.perform(get("/nodes")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name").value(node.getName()));
	}

}
