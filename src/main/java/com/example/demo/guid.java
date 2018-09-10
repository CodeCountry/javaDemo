package com.example.demo;
import java.util.UUID;

public class guid {

    public static void main (String[] args){
        UUID uuid = UUID.randomUUID();
        System.out.println(uuid.toString());
    }

}
