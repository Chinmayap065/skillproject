package com.mtd.EcomApp;

import java.util.List;

import static org.mockito.Mockito.when; // ✅ Needed for mocking
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.mtd.EcomApp.entity.Product;
import com.mtd.EcomApp.service.ProductService; // ✅ Import the actual service

@WebMvcTest
public class ProductServiceTest {

    @Autowired
    private MockMvc mockMvc; // ✅ MockMvc should be @Autowired, not @MockBean

    @MockitoBean
    private ProductService service; // ✅ Mock the service, not the test class itself

    @Test
    void shouldReturnAllProducts() throws Exception {
        when(service.getProducts()).thenReturn(
            List.of(new Product("1", "lennovo", "Desc", 40000, "dsds", 50))
        ); // ✅ Fixed method + List usage

        mockMvc.perform(get("/products/all"))
            .andExpect(status().isOk()) // ✅ Corrected "andExcept" → "andExpect"
            .andExpect(jsonPath("$[0].name").value("lennovo")); // ✅ Corrected value
    }
}
