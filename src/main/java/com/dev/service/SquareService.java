package com.dev.service;

import com.dev.WrongInpuStringException;

public class SquareService {
    char[][] matrixOfChars;

    public SquareService(String inputString) {
        if (inputString == null
                || (Math.sqrt(inputString.length())
                - Math.floor(Math.sqrt(inputString.length())) > 0)
                || inputString.length() == 0
        ) {
            throw new WrongInpuStringException(
                    "You can't made square matrix from this parameters!");
        }
        this.matrixOfChars = formMatrixFromString(inputString);
    }

    private char[][] formMatrixFromString(String s) {
        int c = (int) Math.sqrt(s.length());
        int p = 0;
        char[][] newMatrix = new char[c][c];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                if (p < s.length()) {
                    newMatrix[i][j] = s.charAt(p);
                }
                p++;
            }
        }
        return newMatrix;
    }

    private String[] getPositionOfWordLeterrsInMatrix(String word) {
        String[] result = new String[word.length()];
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < matrixOfChars.length; j++) {
                if (result[i] != null) {
                    continue;
                }
                for (int k = 0; k < matrixOfChars[i].length; k++) {
                    if (String.valueOf(word.charAt(i))
                            .equals(String.valueOf(matrixOfChars[j][k]))) {
                        result[i] = "[" + j + "," + k + "]";
                        continue;
                    }
                }
            }
        }
        return result;
    }

    public String getResult(String word) {
        String[] positionOfChars = getPositionOfWordLeterrsInMatrix(word);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < positionOfChars.length; i++) {
            if (positionOfChars[i] == null) {
                stringBuilder.append("[X]");
            } else {
                stringBuilder.append(positionOfChars[i]);
            }
            if (i == positionOfChars.length - 1) {
                continue;
            }
            stringBuilder.append("->");
        }
        return stringBuilder.toString();
    }
}
