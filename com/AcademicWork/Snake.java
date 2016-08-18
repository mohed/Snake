package com.AcademicWork;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public List<Part> parts = new ArrayList<>();
    public Part posOfLastPart = new Part(0, 0);
    public Part head = new Part(10, 10);
    Part holder = new Part(0, 0);

    public Snake() {
        parts.add(head);
    }

    public void moveSnake(char key) {
        posOfLastPart.copyLocation(head);

        switch (key) {
            case 'U':
                head.y -= 1;
                break;
            case 'D':
                head.y += 1;
                break;
            case 'L':
                head.x -= 1;
                break;
            case 'R':
                head.x += 1;
                break;
        }

        for (int i = 1; i < parts.size(); i++) {
            holder.copyLocation(parts.get(i)); //posOfLastPart);
            parts.get(i).copyLocation(posOfLastPart);
            posOfLastPart.copyLocation(holder);
        }

    }

    public boolean isAlive() {
        if (head.x == 0 || head.y == 0 || head.x == 30 || head.y == 30) {
            return false;
        }
        for (int i = 1; i < parts.size(); i++) {
            if (head.hasSamePosition(parts.get(i))) {
                return false;
            }
        }
        return true;
    }
}
