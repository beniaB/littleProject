package pl.connectis.cschool.jcourse.restservice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import pl.connectis.cschool.jcourse.restservice.domain.Sender;
import pl.connectis.cschool.jcourse.restservice.repository.SenderRepository;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by Benia on 2017-06-23.
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
public class SenderTest {

    private MockMvc mockMvc1;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    SenderRepository senderRepository;

    @Before
    public void setup() {

        mockMvc1 = webAppContextSetup(webApplicationContext).build();

    }


    @Test
    public void addSenderTest() throws Exception {

        String json = convertToJSON(new Sender(3l, "Karol"));

        mockMvc1.perform(post("/senders").content(json).contentType(APPLICATION_JSON_UTF8)).
                andExpect(status().isOk());
        mockMvc1.perform(get("/senders")).andExpect(jsonPath("$..senderName", hasItem("Karol")));

    }

    @Test
    public void getAllSenderTest() throws Exception {

        mockMvc1.perform(get("/senders")).
                andExpect(status().isOk()).
                andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).
                andExpect(jsonPath("$..senderName", hasSize(1)));

    }


    private String convertToJSON(Object o) throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        return om.writeValueAsString(o);
    }

}
