package com.proyectopd.omnichannel.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

// Our intention here is to test the rest controller
// for the role endpoint. Since we are dealing with an isolated
// folder, we will try to mock the service layer implied during
// the process.

// The @WebMvcTest Annotation mocks the other dependencies used within
// the controller class, and launches the actual controller, which
// is the one intended to be tested.

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc(addFilters = false)
public class RolIntegrationControllerTest {

    String BASE_URL = "/rol";

    @Autowired
    private MockMvc mockMvc;

    // Use @Mock instead of mock bean, since tests end up being
    // more portable and lightweight
    /*@Mock
    private RolService rolService;*/

    // Why does the test have to throw an exception?
    // Because we want to catch any exception produced during the test
    // execution. Doing it this way ensures we do not write boiler plate code
    // such as wrapping the whole code of the method within a try catch block.
    @Test
    public void testCreateNewRoles() throws Exception {

        // What does the when(...).thenReturn(...)
        // clause does ?
        // Defines the behavior of a mocked object.
        /*when(rolService.createNewRol(newRol)).thenReturn(true);*/

        ArrayList<String> roleNames = new ArrayList<>();

        roleNames.add("Empresa");
        roleNames.add("Profesional");
        roleNames.add("Administrador");

        for (String roleName : roleNames) {
            mockMvc.perform(post(BASE_URL + "/nuevoRol")
                            .param("newRol", roleName).characterEncoding("UTF-8"))
                    .andExpect(status().isCreated());
        }

        for (String roleName : roleNames) {

            mockMvc.perform(get(BASE_URL + "/nombreRol").param("nombreRol", roleName))
                    .andExpect(status().isOk());
        }


    }

}
