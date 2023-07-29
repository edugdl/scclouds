import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Primos {

    public static Boolean is_prime_linear(int n, List<Integer> primes) {
        int limit = (int)(Math.sqrt(Double.valueOf(n)));
        for (int prime : primes) {
            if (prime > limit) {
                break;
            }
            if (n % prime == 0) {
                return false;
            }
        }
        return true;
    } 

    public static List<Integer> linear_solution(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (is_prime_linear(i, primes)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static Boolean is_prime_recursive(int n, int d) {
        int limit = (int)(Math.sqrt(Double.valueOf(n)));
        if (n == 2) {
            return true;
        }
        if (n % d == 0) {
            return false;
        }
        if (d > limit) {
            return true;
        }
        return is_prime_recursive(n, d+1);

    }

    public static List<Integer> recursive_solution(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (is_prime_recursive(i, 2)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        Boolean run;
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("Insira um número para obter todos os primos até ele:");
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input < 2) {
                    System.out.println("Você deve inserir um número maior ou igual a 2");
                } else {
                    System.out.println("Resultado da solução linear: " + linear_solution(input));
                    System.out.println("Resultado da solução recursiva: " + recursive_solution(input));
                }
            } else {
                System.out.println("Por favor, insira um número maior ou igual a 2");
            }
            System.out.println("0 - Sair\n1 - Continuar");
            run = !sc.next().equals("0");
        } while (run);
        sc.close();
    }
}
