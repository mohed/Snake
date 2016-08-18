package com.AcademicWork;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalSize;

import java.nio.charset.Charset;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        Random random = new Random();
        Key key;
        String deathmsg = "Game over";

        Snake snake = new Snake();
        Part food = new Part(random.nextInt(20), random.nextInt(20));
        char presentKey = 'R';

        boolean alive = true;
        while (alive) {
            Thread.sleep(250);
            key = terminal.readInput();
            if (key != null) {
                presentKey = key.getCharacter();
            }
            // presentKey = getKeyPress(terminal, presentKey);
            snake.moveSnake(presentKey);
            if (snake.parts.get(0).x == food.x && snake.parts.get(0).y == food.y) {
                snake.parts.add(new Part(snake.posOfLastPart.x, snake.posOfLastPart.y));
                food.x = random.nextInt(20);
                food.y = random.nextInt(20);
            }
            updateTerminal(terminal, snake, food);
            alive = snake.isAlive();
        }
        terminal.clearScreen();
        terminal.moveCursor(10, 10);
        for (int i = 0; i < deathmsg.length(); i++) {
            terminal.putCharacter(deathmsg.charAt(i));
        }
    }

    public static void updateTerminal(Terminal terminal, Snake snake, Part food) {
        terminal.clearScreen();
        for (int i = 0; i < 31; i++) {
            terminal.moveCursor(i, 0);
            terminal.putCharacter('+');
            terminal.moveCursor(i, 30);
            terminal.putCharacter('+');

        }
        for (int i = 1; i < 30; i++) {
            terminal.moveCursor(0, i);
            terminal.putCharacter('+');
            terminal.moveCursor(30, i);
            terminal.putCharacter('+');
        }

        for (Part part : snake.parts) {
            terminal.moveCursor(part.x, part.y);
            System.out.println(snake.parts.size());
            if (part == snake.parts.get(0)) {
                terminal.putCharacter('L');
            } else {
                terminal.putCharacter('O');
            }
            terminal.moveCursor(food.x, food.y);
            terminal.putCharacter('X');
        }
        terminal.moveCursor(0, 0);
    }
}

