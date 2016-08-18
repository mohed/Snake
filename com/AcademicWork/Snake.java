package com.AcademicWork;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    public List<Part> parts = new ArrayList<>();
    public Part posOfLastPart;

    public Snake() {
        parts.add(new Part(10, 10));
    }

    public void moveSnake(String keyhistory) {
        posOfLastPart = this.parts.get(0);


        switch (keyhistory.charAt(0)) {
            case 'U':
                this.parts.get(0).y -= 1;
                break;
            case 'D':
                this.parts.get(0).y += 1;
                break;
            case 'L':
                this.parts.get(0).x -= 1;
                break;
            case 'R':
                this.parts.get(0).x += 1;
                break;
        }
        for (int i = parts.size()-1; i > 0; i--){
            Part holder = new Part(parts.get(i).x, parts.get(i).y);
            this.parts.get(i).x = posOfLastPart.x;
            this.parts.get(i).y = posOfLastPart.y;
            posOfLastPart = holder;
        }

        // }

    }
}
