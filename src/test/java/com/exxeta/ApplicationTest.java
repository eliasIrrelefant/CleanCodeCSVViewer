package com.exxeta;

import org.junit.Test;

public class ApplicationTest {

    private Main main = new Main();
    
    // How to simulate input ?
    @Test
    private void shouldSuccessfullyRunTheApplication() {
        String[] args = new String[1];
        args[0] = "test2.csv";
        main.main(args);
    }
}
