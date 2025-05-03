package com.proyectopd.omnichannel.controllers;

import com.proyectopd.omnichannel.models.Rol;
import com.proyectopd.omnichannel.services.RolService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.*;

import static org.mockito.Mockito.when;

// Our intention here is to test the rest controller
// for the role endpoint. Since we are dealing with an isolated
// folder, we will try to mock the service layer implied during
// the process.

// The @WebMvcTest Annotation mocks the other dependencies used within
// the controller class, and launches the actual controller, which
// is the one intended to be tested.

@WebMvcTest(RolController.class)
public class RolControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Use @Mock instead of mock bean, since tests end up being
    // more portable and lightweight
    @Mock
    private RolService rolService;

    // Why does the test have to throw an exception?
    // Because we want to catch any exception produced during the test
    // execution. Doing it this way ensures we do not write boiler plate code
    // such as wrapping the whole code of the method within a try catch block.
    @Test
    public void testCreateNewRole() throws Exception {
        Rol newRol = new Rol("Administrador");

        // What does the when(...).thenReturn(...)
        // clause does ?
        // Defines the behavior of a mocked object.
        when(rolService.createNewRol(newRol)).then();

    }
}
