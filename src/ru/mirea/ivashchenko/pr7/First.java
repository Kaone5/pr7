package ru.mirea.ivashchenko.pr7;

import java.util.Scanner;
import java.util.Stack;

public class First {
    static void game(Stack<Integer> first, Stack<Integer> second, Stack<Integer>third, Stack<Integer>fourth)
    {
        int step = 0;
        while ((!first.isEmpty() || !third.isEmpty()) && (!second.isEmpty() || !fourth.isEmpty()) && step < 106) {

            if (third.isEmpty()) {
                while (!first.isEmpty()) {
                    third.push(first.pop());
                }
            }

            if (fourth.isEmpty()) {
                while (!second.isEmpty()) {
                    fourth.push(second.pop());
                }
            }

            step++;
            int s3 = third.pop();
            int s4 = fourth.pop();

                if (s3 > s4 && !(s4 == 0 && s3 == 9) || (s3 == 0 && s4 == 9)) {
                    first.push(s3);
                    first.push(s4);
                }
                else {
                    second.push(s3);
                    second.push(s4);
                }
            }

        if (first.isEmpty() && third.isEmpty()) {
            System.out.println("second " + step);
        }

        else if (second.isEmpty() && fourth.isEmpty()){
            System.out.println("first " + step);
        }

        else {
            System.out.println("botva");
        }
    }

    public static void main(String[] args)
    {
        var first  = new Stack<Integer>();
        var second = new Stack<Integer>();
        var third = new Stack<Integer>();
        var fourth = new Stack<Integer>();

        Scanner reader = new Scanner(System.in);

        for(int i = 0; i < 5; i++)
        {
            int input = reader.nextInt();
            first.push(input);
        }

        for(int i = 0; i < 5; i++)
        {
            int input = reader.nextInt();
            second.push(input);
        }
        game(first, second, third, fourth);
    }
}