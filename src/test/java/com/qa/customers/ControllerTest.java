package com.qa.customers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.client.RequestMatcher;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.customers.domain.Customer;

@SpringBootTest
@AutoConfigureMockMvc // acts like your postman - makes the test requests
@Sql(scripts = { "classpath:customer-schema.sql",
        "classpath:customer-data.sql" }, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD) // pre-populate the
                                                                                                    // database
@ActiveProfiles("test")
public class ControllerTest {
    @Autowired
    private MockMvc mock;
    
    @Autowired
    private ObjectMapper map;
    
    //Create Test
    @Test
    void createTest() throws Exception {
        Customer newC = new Customer("Jeff", 25, "jeff@mail.com");
        String newCJSON = this.map.writeValueAsString(newC);
        RequestBuilder mockRequest = post("/customers/postCustomer").contentType(MediaType.APPLICATION_JSON).content(newCJSON);
        Customer savedC = new Customer(2L, "Jeff", 25, "jeff@mail.com");
        String savedCJSON = this.map.writeValueAsString(savedC);
        ResultMatcher matchStatus = status().isCreated();
        ResultMatcher matchBody = content().json(savedCJSON);
        this.mock.perform(mockRequest).andExpect(matchStatus).andExpect(matchBody);
    }
    
    //Read All Test
    @Test
    void readTest() throws Exception {
        Customer readC = new Customer(1L, "Fred", 21, "fred@mail.com");
        List<Customer> allCust = List.of(readC);
        String readCustJSON = this.map.writeValueAsString(allCust);
        RequestBuilder readReq = get("/customers/getAll");
        ResultMatcher status = status().isFound();
        ResultMatcher body = content().json(readCustJSON);
        this.mock.perform(readReq).andExpect(status).andExpect(body);
    }
    
    //ReadById Test
    @Test
    void readByIdTest() throws Exception {
    	Customer readC = new Customer(1L, "Fred", 21, "fred@mail.com");
    	String readCustJSON = this.map.writeValueAsString(readC);
    	RequestBuilder readReq = get ("/customers/getById/" + 1L);
    	ResultMatcher status = status().isFound();
    	ResultMatcher body = content().json(readCustJSON);
    	this.mock.perform(readReq).andExpect(status).andExpect(body);
    }
    
    //Update Test
    @Test
    void updateTest() throws Exception {
        Customer updateCust = new Customer("John", 29, "john@mail.com");
        String updateCustJSON = this.map.writeValueAsString(updateCust);
        Long IdUpdate = 1L;
        RequestBuilder updateReq = put("/customers/updateById/" + IdUpdate).contentType(MediaType.APPLICATION_JSON).content(updateCustJSON);
        Customer retUpdatedCust = new Customer(1L, "John", 29, "john@mail.com");
        String retUpdatedCustJSON = this.map.writeValueAsString(retUpdatedCust);
        ResultMatcher retStatus = status().isAccepted();
        ResultMatcher retBody = content().json(retUpdatedCustJSON);
        this.mock.perform(updateReq).andExpect(retStatus).andExpect(retBody);
    }
    
    //Delete Test if exists
    @Test
    void deleteTest() throws Exception {
        Long delId = 1L;
        RequestBuilder delRequest = delete("/customers/deleteById/" + delId);
        ResultMatcher Status = status().isAccepted();
        ResultMatcher Body = content().string("true");
        this.mock.perform(delRequest).andExpect(Status).andExpect(Body);
    }
    
    //Delete Test if not exists
    @Test
    void noDeleteTest() throws Exception {
    	Long delId = 4L;
    	RequestBuilder delRequest = delete("/customers/deleteById/" + delId);
    	ResultMatcher Status = status().isNotAcceptable();
    	ResultMatcher Body = content().string("false");
    	this.mock.perform(delRequest).andExpect(Status).andExpect(Body);
    }
}
