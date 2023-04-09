import java.util.Scanner;
import java.util.Vector;
import java.util.HashMap;

public class Primes {

    public static boolean isPrime(int n) {
        for (int i = 2 ;i <= Math.sqrt(n) ;i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static int gcdPrime(int a ,int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        int i = 2;
        while (!isPrime(n)) {
            if (n % i == 0) {
                n = n / i;
            } else {
                i = nextPrime(i);
            }
        }
        return n;
    }

    public static Vector<Integer> primeLiquidation(int num) {
        int i = 2;
        Vector<Integer> v = new Vector<Integer>();
        while (i <= num) {
            while (num % i == 0) {
                v.addElement(i);
                num = num / i;
            }
            i++;
        }
        return v;
    }

    public static int gcd(int a ,int b) {
        int m = Math.max(a, b);
        int n = Math.min(a, b);
        int r = m % n;
        while (r != 0) {
            m = n;
            n = r;
            r = m % n;
        }
        return n;
    }

    public static int gcdRec(int a ,int b) {
        if (b == 0)
            return a;
        return gcdRec(b ,a % b);
    }

    public static int lcm(int a ,int b){
        return (a * b) / gcdRec(a,b);
    }

    public static int countPrimes(int low ,int high) {
        int c = 0;
        for (int i = low ;i <= high ;i++)
            if (isPrime(i))
                c++;
        return c;
    }

    public static void printPrimes(int low ,int high) {
        for (int i = low ;i <= high ;i++)
            if (isPrime(i))
                System.out.println(i);
    }

    public static int nextPrime(int x) {
        int x1 = x + 1;
        while (!isPrime(x1))
            x1++;
        return x1;
    }

    public static int prevPrime(int x) {
        if (x == 2)
            return x;
        else {
            int x1 = x - 1;
            while (!isPrime(x1))
                x1--;
            return x1;
        }
    }

    public static int sequenceNonPrime(int low ,int high) {
        int max = -1 ,a = low;;
        high = nextPrime(high);
        while (a <= high) {
            int b = nextPrime(a);
            if (b - a > max)
                max = b - a;
            a = b;
        }
        return max - 1;
    }

    public static Vector<Integer> powersArray(Vector<Integer> v) {
        int c = 1;
        Vector<Integer> vm = new Vector<Integer>();
        for (int i = 0 ;i < v.size() - 1 ;i++) {
            if (v.get(i).equals(v.get(i + 1)))
                c++;
            else {
                vm.addElement(c);
                c = 1;
            }
        }
        if (v.get(v.size() - 1).equals(v.get(v.size() - 2)))
            vm.addElement(c);
        else
            vm.addElement(1);
        return vm;
    }

    public static Vector<Integer> primesArray(Vector<Integer> v) {
        Vector<Integer> vn = new Vector<Integer>();
        int j = v.size() - 1;
        for (int i = 0 ;i < v.size() - 1 ;i++)
            if (!v.get(i).equals(v.get(i + 1)))
                vn.addElement(v.get(i));
        vn.addElement(v.get(j));
        return vn;
    }

    public static void treeCommotative(int n) {
        System.out.println("tree commotative: ");
        int p = 2 ,h = 0;
        while (p <= Math.sqrt(n)) {
            while (!isPrime(n) && (n % p == 0)) {
                int q = n / p;
                System.out.println(n + " -> " + "left = " + p + " ,right = " + q);
                n = q;
                h++;
            }
            p++;
        }
        System.out.println("height = " + h);
    }

    public static void treeCommotativeRec(int p ,int n ,int h) {
        if (isPrime(n)) {
            System.out.println("height = " + h);
        } else {
            while (!isPrime(p) || (n % p != 0)) {
                p++;
            }
            int q = n / p;
            System.out.println(n + " -> " + "left = " + p + " ,right = " + q);
            treeCommotativeRec(p ,q ,h + 1);
        }
    }

    public static int heightTreeCommotative(int n) {
        if (isPrime(n)) {
            return 0;
        } else {
            int p = 2;
            while (!isPrime(p) || (n % p != 0)) {
                p++;
            }
            return 1 + heightTreeCommotative(n / p);
        }
    }

    public static HashMap<Integer ,Vector<Integer>> dictionaryPrimes(int n) {
        HashMap<Integer ,Vector<Integer>> vm = new HashMap<Integer ,Vector<Integer>>(n);
        int c = 2;
        while (c <= n) {
            vm.put(c ,primeLiquidation(c));
            c++;
        }
        return vm;
    }

    public static void main(String[] args) {
        HashMap<Integer ,Vector<Integer>> vm = dictionaryPrimes(2048);
        for(int key: vm.keySet())
            System.out.println(key + " = " + vm.get(key));
        System.out.println();
//        Vector<Integer> v = primeLiquidation(24);
//        System.out.println(v);
//        System.out.println();
        treeCommotative(24);
        System.out.println();
//        int t = sequenceNonPrime(12,24);
//        System.out.println(t);
        int k = gcdPrime(6,12);
        System.out.println(k);
    }
}