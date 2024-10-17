import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    //Лабораторная работа №2
    static Scanner in = new Scanner(System.in);
    
    static String task1(String str)
    {
        String max_sub = "";
        boolean f = true;
        int last_ind = 0;

        while (f)
        {
            String cur_sub = "";

            for (int i = last_ind; i < str.length(); i++)
            {
                if (cur_sub.contains(String.valueOf(str.charAt(i))))
                {
                    if (max_sub.length() < cur_sub.length())
                    {
                        max_sub = cur_sub;
                    }
                    last_ind++;

                    break;
                }
                else
                {
                    cur_sub += str.charAt(i);

                    if (i == str.length() - 1) // последний элемент
                    {
                        if (max_sub.length() < cur_sub.length())
                        {
                            max_sub = cur_sub;
                        }

                        f = false;
                    }
                }
            }
        }
        return max_sub;
    }

    static int[] task2(int[] array1, int[] array2)
    {
        int[] array = new int[array1.length + array2.length];

        for(int i = 0; i < array1.length; i++)
        {
            array[i] = array1[i];
        }

        for(int j = array1.length; j < array.length; j++)
        {
            array[j] = array2[j - array1.length];
        }

        Arrays.sort(array);

        return array;
    }

    static int task3(int[] array)
    {
        int [] time_mas = {};

        int a_l = array.length;

        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < a_l; i++)
        {
            int tmp_sum = array[i];
            for  (int j = i + 1; j < a_l; j++)
            {
                tmp_sum = tmp_sum + array[j];
                if (max_sum < tmp_sum)
                {
                    max_sum = tmp_sum;
                }
                else
                {
                    break;
                }
            }
        }
        return max_sum;
    }

    static int[][] task4(int[][] array)
    {
        int strings = array.length;
        int columns = array[0].length;
        int[][] res = new int[columns][strings];

        for (int i = strings - 1; i >= 0; i--)
        {
            for (int j = 0; j < columns; j++)
            {
                res[j][strings - i - 1] = array[i][j];
            }
        }

        return res;
    }

    static int[] task5(int[] array, int target)
    {
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++)
                if (i != j)
                    if (array[i] + array[j] == target)
                        return new int[]{array[i], array[j]};
        return null;
    }

    static int task6(int[][] array)
    {
        int sum = 0;
        for (int[] str: array)
            for (int el: str)
                sum += el;
        return sum;
    }

    static int[] task7(int[][] array)
    {
        int[] res_array = new int[array.length];
        for (int i = 0; i < array.length; i++)
        {
            int max_el = Integer.MIN_VALUE;
            for (int j = 0; j < array[i].length; j++)
            {
                if (max_el < array[i][j])
                {
                    max_el = array[i][j];
                }
            }
            res_array[i] = max_el;
        }
        return res_array;
    }

    static int[][] task8(int[][] array)
    {
        int strings = array.length;
        int columns = array[0].length;
        int[][] res = new int[columns][strings];

        for (int i = 0; i < strings; i++)
        {
            for (int j = columns - 1; j >= 0; j--)
            {
                res[columns - j - 1][i] = array[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        //Task1
        System.out.println(task1("everythingisfine"));

        //Task2
        int[] array1 = {5, 3, 9, 4, 6};
        int[] array2 = {7, 7, 1, 0, 2};
        System.out.println(Arrays.toString(task2(array1, array2)));

        //Task3
        int[] array3 = {-612, 3, 8, -7, 19, -85, 77};
        System.out.println(task3(array3));

        //Task4
        int[][] array4 = {
                {3, 6, 9, 12},
                {2, 5, 8, 11},
                {1, 4, 7, 10}};
        int[][] array3_new = task4(array4);
        for (int[] str : array3_new)
        {
            for (int el : str)
            {
                System.out.print(el + " ");
            }
            System.out.println();
        }

        //Task5
        int[] array5 = {11, 2, 612, 8, 3};
        int target = 13;
        System.out.println(Arrays.toString(task5(array5, target)));

        //Task6
        int[][] array6 = {
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10}};
        System.out.println(task6(array6));

        //Task7
        System.out.println(Arrays.toString(task7(array6)));

        //Task8
        int[][] result = task8(array4);
        for (int[] str : result)
        {
            for (int el : str)
            {
                System.out.print(el + " ");
            }
            System.out.println();
        }
    }
}