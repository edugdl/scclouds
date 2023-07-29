import java.util.Scanner;

public class Fibonnacci {

    public static int linear_solution (int n) {
        if (n == 0 || n == 1){
            return n;
        }
        int temp;
        int previous = 0;
        int current = 1;
        for (int i = 0; i < n-1; i++) {
            temp = current;
            current += previous;
            previous = temp;
        }
        return current;
    }

    public static int recursive_solution (int n) {
        if (n == 0 || n == 1){
            return n;
        }
        return recursive_solution(n-1) + recursive_solution(n-2);
    }

    public static void main(String[] args) {
        Boolean run;
        Scanner sc = new Scanner(System.in);
        int input;

        do {
            System.out.println("Qual termo da sequência de Fibonnacci deseja obter ?");
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input < 0) {
                    System.out.println("Você deve inserir um número maior ou igual a 0");
                } else {
                    System.out.println("Resultado da solução linear: " + linear_solution(input));
                    System.out.println("Resultado da solução recursiva: " + recursive_solution(input));
                }
            } else {
                System.out.println("Por favor, insira um número maior ou igual a 0");
            }
            System.out.println("0 - Sair\n1 - Continuar");
            run = !sc.next().equals("0");
        } while (run);
        sc.close();
    }
}