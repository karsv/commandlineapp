package com.dev;

import com.dev.service.SquareService;

public class Main {
    public static void main(String[] args) {
        SquareService squareService = new SquareService(args[0]);
        System.out.println(squareService.getResult(args[1]));
    }
}
