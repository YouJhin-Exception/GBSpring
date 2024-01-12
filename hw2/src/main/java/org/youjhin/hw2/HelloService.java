package org.youjhin.hw2;


import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String getGreeting() {
        return " ☃\uFE0F Привет Евгений! \uD83C\uDFC2";
    }
}
