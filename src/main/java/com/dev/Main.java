package com.dev;

import com.dev.service.SquareService;

public class Main {
    public static void main(String[] args) {
        SquareService squareService = new SquareService();
        System.out.println(squareService.getResult(args[0], args[1]));
    }
}
