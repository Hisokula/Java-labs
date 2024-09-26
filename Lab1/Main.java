import java.util.Objects;
import java.util.Scanner;

public class Main
{
    //Лабораторная работа №1
    static Scanner in = new Scanner(System.in);
    public static void task1()
    {
        System.out.println("Задание №1");
        System.out.println("Сиракузская последовательность:");

        int n = in.nextInt();
        while (n != 1)
        {
            if (n % 2 == 0)
            {
                n /= 2;
                System.out.println(n);
            }
            else
            {
                n = 3*n + 1;
                System.out.println(n);
            }
        }
    }

    public static void task2()
    {
        System.out.println("Задание №2");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            int t = in.nextInt();
            if(i % 2 == 0)
            {
                sum += t;
            }
            else
            {
                sum -= t;
            }
        }
        System.out.println("Сумма ряда:");
        System.out.println(sum);
    }

    public static void task3()
    {
        System.out.println("Задание №3");
        Scanner in = new Scanner(System.in);
        int x_treasure = in.nextInt();
        int y_treasure = in.nextInt();
        int x_current = 0;
        int y_current = 0;
        String action = "";
        int count = 0;
        while (true)
        {
            if (in.hasNextInt())
            {
                int currentValue = in.nextInt();
                if (x_treasure == x_current & y_treasure == y_current)
                {
                    continue;
                } else
                {
                    switch (action)
                    {
                        case "север":
                            y_current += currentValue;
                            break;
                        case "юг":
                            y_current -= currentValue;
                            break;
                        case "запад":
                            x_current -= currentValue;
                            break;
                        case "восток":
                            x_current += currentValue;
                            break;
                        default:
                            throw new RuntimeException("ошибка");
                    }
                    count++;
                }
            }
            else
            {
                action = in.nextLine();
                if (Objects.equals(action, "стоп"))
                {
                    break;
                }
            }
        }
        System.out.println("Шагов требуется:" + count);
    }

    public static void task4()
    {
        System.out.println("Задание №4");
        int max_height = 0;
        int chosen_path = -1;
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            int count = in.nextInt();
            int min_height = Integer.MAX_VALUE;
            for(int j = 0; j < count; j++)
            {
                int cur_height = in.nextInt();
                min_height = Integer.min(cur_height, min_height);
            }
            if (min_height > max_height)
            {
                max_height = min_height;
                chosen_path = i + 1;
            }
        }
        System.out.println("Оптимальная дорога: " + chosen_path + " " + max_height);
    }

    public static void task5()
    {
        System.out.println("Задание №5");
        Scanner in = new Scanner(System.in);
        boolean f = false;
        int n = in.nextInt();
        if (n < 1000 & n > 99)
        {
            int a = n / 100;
            int b = (n / 10) % 10;
            int c = n % 10;
            f = (a * b * c % 2 == (a + b + c) % 2) & (a * b * c % 2 == 0);
        }
        System.out.println("Число является дважды чётным: " + f);
    }

    public static void main(String[] args)
    {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

}