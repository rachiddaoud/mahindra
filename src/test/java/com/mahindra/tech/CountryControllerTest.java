package com.mahindra.tech;



import com.mahindra.tech.controller.CountryController;
import com.mahindra.tech.service.CityService;
import com.mahindra.tech.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.context.bean.override.mockito.MockitoBean;


@WebMvcTest(CountryController.class)
public class CountryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private CountryService countryService;

    @MockitoBean
    private CityService cityService;

    @Test
    void shouldReturnOKhenGettingCountries() throws Exception {
        mockMvc.perform(get("/countries"))
                .andExpect(status().isOk());
    }
}
