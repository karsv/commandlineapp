package com.dev.service;

import com.dev.NoResultException;
import com.dev.WrongInpuStringException;

import java.util.ArrayList;
import java.util.List;

public class SquareService {
    private static final int[] ROW = {-1, 0, 0, 1};
    private static final int[] COL = {0, -1, 1, 0};

    boolean isNextStep(Letter next, List<Letter> path, int len) {
        return (next.posX >= 0) && (next.posX < len) && (next.posY >= 0)
                && (next.posY < len) && (!path.contains(next));
    }

    private void impOfDeepFindSearch(char[][] matrix, String word, Letter next,
                                     List<Letter> path, int index, List<Letter> result) {
        int i = next.posX;
        int j = next.posY;
        int n = word.length();

        if (matrix[i][j] != word.charAt(index)) {
            return;
        }

        if (index == n - 1) {
            path.add(new Letter(i, j));
            for (Letter letter : path) {
                result.add(letter);
            }
            return;
        }

        path.add(new Letter(i, j));

        for (int k = 0; k < 4; k++) {
            next = new Letter(i + ROW[k], j + COL[k]);

            if (isNextStep(next, path, matrix.length)) {
                impOfDeepFindSearch(matrix, word, next, path, index + 1, result);
            }
        }
        path.remove(path.size() - 1);
        return;
    }

    private char[][] formMatrixFromString(String inputString) {
        if (inputString == null
                || (Math.sqrt(inputString.length())
                - Math.floor(Math.sqrt(inputString.length())) > 0)
                || inputString.length() == 0) {
            throw new WrongInpuStringException(
                    "You can't made square matrix from this parameters!");
        }
        int rowsColumns = (int) Math.sqrt(inputString.length());
        int positionOfCharInInputString = 0;
        char[][] newMatrix = new char[rowsColumns][rowsColumns];
        for (int i = 0; i < rowsColumns; i++) {
            for (int j = 0; j < rowsColumns; j++) {
                if (positionOfCharInInputString < inputString.length()) {
                    newMatrix[i][j] = inputString.charAt(positionOfCharInInputString);
                }
                positionOfCharInInputString++;
            }
        }
        return newMatrix;
    }

    private String[] getPositionOfWordLeterrsInMatrix(char[][] matrixOfChars, String word) {
        String[] stringResult = new String[word.length()];
        List<Letter> path = new ArrayList<>();
        List<Letter> result = new ArrayList<>();

        for (int i = 0; i < matrixOfChars.length; ++i) {
            for (int j = 0; j < matrixOfChars.length; ++j) {
                impOfDeepFindSearch(matrixOfChars, word, new Letter(i, j), path, 0, result);
            }
        }

        if (result.size() == 0) {
            throw new NoResultException("There isn't any word!");
        }

        for (int i = 0; i < word.length(); ++i) {
            stringResult[i] = result.get(i).toString();
        }
        return stringResult;
    }

    public String getResult(String stringForMatrix, String word) {
        char[][] matrix = formMatrixFromString(stringForMatrix);

        if (word == null || word.length() == 0) {
            throw new WrongInpuStringException("The input parameters of finding word is wrong!");
        }

        String[] positionOfChars = getPositionOfWordLeterrsInMatrix(matrix, word);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < positionOfChars.length; i++) {
            stringBuilder.append(positionOfChars[i]);
            if (i == positionOfChars.length - 1) {
                continue;
            }
            stringBuilder.append("->");
        }
        return stringBuilder.toString();
    }

    private static class Letter {
        int posX;
        int posY;

        public Letter(int x, int y) {
            this.posX = x;
            this.posY = y;
        }

        @Override
        public String toString() {
            return ("[" + posX + "," + posY + "]");
        }
    }
}
