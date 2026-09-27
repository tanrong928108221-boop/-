import java.util.Scanner;

    public class student{
        public static void main (String [] args){
        
        //Start
        Scanner input = new Scanner (System.in);
        System.out.println("Enter Input Student");
        String Student =input.nextLine();

        System.out.println ("Input Name ID");
        String Name = input.nextLine();//Rong

        System.out.println ("Enter Input Age");
        int Age = input.nextInt();//0;

        System.out.println ("Input score");
        double score = input.nextDouble();//29.9;

        System.out.println("Check if there is a correct");
        
        System.out.println("Check if there is a mistake");

        input.close();

        }
}

        
    