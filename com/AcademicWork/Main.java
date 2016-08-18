package com.AcademicWork;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        Key key;
        Random random = new Random();
        String keyHistory = "R";
        Part food = new Part(random.nextInt(20), random.nextInt(20));
        char keyPress = 'a';

        Snake snake = new Snake();

        boolean alive = true;
        while (alive) {

            keyPress = getKeyPress(terminal, keyHistory);

//            Thread.sleep(5);
//            key = terminal.readInput();
            keyHistory = keyHistory + keyPress;
            keyHistory = keyHistory.substring(1);
            System.out.println(keyHistory);
            snake.moveSnake(keyHistory);
            if (snake.parts.get(0).x == food.x && snake.parts.get(0).y == food.y){
                snake.parts.add(new Part(snake.posOfLastPart.x, snake.posOfLastPart.y));
                food.x = random.nextInt(20);
                food.y = random.nextInt(20);
                // keyHistory = 'n' + keyHistory;
            }
            updateTerminal(terminal, snake, food);
        }

    }

    public static void updateTerminal(Terminal terminal, Snake snake, Part food) {
        terminal.clearScreen();
        for (Part part : snake.parts) {
            terminal.moveCursor(part.x, part.y);
            System.out.println(part.x + " " + part.y);
            terminal.putCharacter('o');
            terminal.moveCursor(food.x, food.y);
            terminal.putCharacter('x');

        }
        terminal.moveCursor(0,0);
    }

    public static char getKeyPress(Terminal terminal, String keyOld) throws InterruptedException {
        Key key;
        Thread.sleep(250);
        key = terminal.readInput();
            if (key == null){
            return keyOld.charAt(0);
        } else {
                return key.getCharacter();
            }

    }

}

