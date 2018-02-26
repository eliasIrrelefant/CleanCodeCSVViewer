package com.company;

import org.junit.jupiter.api.Test;

class ApplicationTest {

    private Main main = new Main();
    
    // How to simulate input ?
    @Test void shouldSuccessfullyRunTheApplication() {
        String[] args = new String[1];
        args[0] = "test2.csv";
        main.main(args);
    }
}
