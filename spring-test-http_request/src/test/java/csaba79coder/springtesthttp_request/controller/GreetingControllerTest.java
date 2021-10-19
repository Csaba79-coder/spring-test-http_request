package csaba79coder.springtesthttp_request.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getGreeting() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/home"))
                .andExpect(
                        MockMvcResultMatchers.status().is(200)
                        // MockMvcResultMatchers.status().isOk() // status 200!!!
                ).andReturn();

        String content = mvcResult.getResponse().getContentAsString();

        assertTrue(content.contains("Hello World from Spring Boot!"));
        assertFalse(content.contains("href=\"/home\""));
        assertFalse(content.contains("data-th-href"));
    }

//    @Test
//    void getBooks() throws Exception {
//        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/books"))
//                .andExpect(
//                        // MockMvcResultMatchers.status().is(200)
//                        MockMvcResultMatchers.status().isOk() // status 200!!!
//                ).andReturn();
//
//        String content = mvcResult.getResponse().getContentAsString();
//
//        assertTrue(content.contains("href=\"/books\""));
//        // assertFalse(content.contains("data-th-href"));
//    }
}