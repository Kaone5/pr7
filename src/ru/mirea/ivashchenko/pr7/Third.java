package ru.mirea.ivashchenko.pr7;

import java.util.LinkedList;
import java.util.Deque;
import java.util.Scanner;

public class Third {
    static void game(Deque<Integer> first, Deque<Integer> second)
    {
        int step = 0;

        while (!first.isEmpty() && !second.isEmpty() && step < 106){
            step++;
            int q1 = first.poll();
            int q2 = second.poll();

            if (q1 > q2 && !(q2 == 0 && q1 == 9) || (q1 == 0 && q2 == 9)) {
                first.offer(q1);
                first.offer(q2);
            }
            else {
                second.offer(q1);
                second.offer(q2);
            }
        }

        if (first.isEmpty()) System.out.println("second " + step);
        else if (second.isEmpty()) System.out.println("first " + step);
        else System.out.println("botva");
    }

    public static void main(String[] args) throws Exception
    {
        Deque first = new LinkedList();
        Deque second = new LinkedList();

        Scanner reader = new Scanner(System.in);

        for(int i = 0; i < 5; i++)
        {
            int input = reader.nextInt();
            first.offer(input);
        }

        for(int i = 0; i < 5; i++)
        {
            int input = reader.nextInt();
            second.offer(input);
        }
        game(first, second);
    }
}
