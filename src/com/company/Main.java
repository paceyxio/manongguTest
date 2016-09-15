package com.company;

import java.util.Scanner;

import static java.lang.Math.abs;

public class Main
{
    public static void main(String[] args)
    {
        int[][] act = new int[100][2];
        int[] sum = new int[10];
        int Ca, L, n, x = 0;         //Ca为测试数据的组数，L表示大街的长度，n表示操作数量
        System.out.println("请输入测试数据的组数");
        Scanner scanner = new Scanner(System.in);
        Ca = scanner.nextInt();
        for (int i = 0; i < Ca; i++)
        {
            System.out.println("输入大街的长度和操作数量");
            L = scanner.nextInt();
            n = scanner.nextInt();
            System.out.println("输入" + n + "次操作");
            boolean flag ;
            for (int j = 0; j < n; j++)
            {
                flag = false;
                act[j][0] = scanner.nextInt();
                if (act[j][0] == 0)
                {
                    act[j][1] = scanner.nextInt();
//                    sum[i] += act[j][1];
                } else if (act[j][0] == 1)
                {
//                    act[j][1] = 0;
                    int[] dis = new int[10];
                    int min = L;
                    int del = 0;
                    int cpy = 0;
                    for (int k = 0,count = 0; k < j; k++)
                    {
                        if (act[k][0] == 0)     //可能存在初始化问题
                        {
                            flag = true;
                            dis[count] = abs(x - act[k][1]);
                            if (min > dis[count])
                            {
                                min = dis[count];
                                del = k;
                                cpy = act[k][1];
                            }
                            count++;
                        }
                    }
                    act[del][0] = -1;
                    x = cpy;
                    if (flag)
                    {
                        sum[i] += min;
                    }
                }
            }
        }
        for (int i = 0; i < Ca; i++)
        {
            System.out.println("Case " + (i + 1) + ": " + sum[i]);
        }
    }
}
