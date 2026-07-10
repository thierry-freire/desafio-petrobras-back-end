package com.challenges.desafiopetrobrasbackend;

import org.springframework.boot.SpringApplication;

public class TestDesafioPetrobrasBackendApplication {

    public static void main(String[] args) {
        SpringApplication.from(DesafioPetrobrasBackendApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
