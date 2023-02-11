package DZ_1.example.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInput {

    Scanner userInput = new Scanner(System.in);


    public int nextInt() throws ConsoleInputExeption {
        try{
            return userInput.nextInt();
        }catch (InputMismatchException e ){
            throw new ConsoleInputExeption("Произошла ошибка при чтении целого числа " + e.getMessage());
        }
    }
    public String nextLine() throws ConsoleInputExeption {
        try{
            return userInput.nextLine();
        }catch (InputMismatchException e ){
            throw new ConsoleInputExeption("Произошла ошибка при чтении строки " + e.getMessage());
        }
    }
    public void clear(){
        userInput.nextLine();
    }

}
