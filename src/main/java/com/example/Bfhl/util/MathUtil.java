package com.example.Bfhl.util;

import java.util.ArrayList;
import java.util.List;

public class MathUtil {

    public static List<Integer> fibonacci(int n) {
        List<Integer> res = new ArrayList<>();
        if (n <= 0) return res;
        int a = 0, b = 1;
        res.add(a);
        if (n > 1) res.add(b);
        for (int i = 2; i < n; i++) {
            int c = a + b;
            res.add(c);
            a = b;
            b = c;
        }
        return res;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * (b / gcd(a, b));
    }
}

