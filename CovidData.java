
import java.util.Scanner;
public class CovidData{
   
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) 
        {
            System.out.println("COVID-19 State Data");
            System.out.println("=====================");
            System.out.print("Enter the number of states involved with COVID-19: ");
            int state_num = sc.nextInt();

            String[] state_name = new String[state_num];
            int[] state_cases1 = new int[state_num];
            int[] state_cases2 = new int[state_num];
            int[] daily_state_cases = new int[state_num];
            int total_cases = 0;
            double average_cases;
            String[] zone_category = new String[state_num];
            int red_zone_counter = 0;

            System.out.print("Enter the name of the states: ");
            for (int i = 0; i < state_num; i++) {
                state_name[i] = sc.next();
            }
            
            System.out.print("Enter the first round of " + state_num + " readings: ");
            for (int i = 0; i < state_num; i++) {
                state_cases1[i] = sc.nextInt();
            }

            System.out.print("Enter the second round of " + state_num + " readings: ");
            for (int i = 0; i < state_num; i++) {
                state_cases2[i] = sc.nextInt();
            }

            System.out.println("*************************");
            System.out.println("List of states:");
            for (int i = 0; i < state_num; i++) {
                System.out.print(state_name[i] + "\t\t");
            }
            System.out.print("\n");
            for (int i = 0; i < state_num; i++) {
                System.out.print(state_cases1[i] + "\t\t");
            }
            System.out.print("\n");
            for (int i = 0; i < state_num; i++) {
                System.out.print(state_cases2[i] + "\t\t");
            }
            System.out.print("\n");
            for (int i = 0; i < state_num; i++) {
                daily_state_cases[i] = state_cases1[i] + state_cases2[i];
                System.out.print(daily_state_cases[i] + "\t\t");
            }
            System.out.println("\n");

            // Sums all of the cases together and then finds the average of the cases.
            System.out.print("Average cases for " + state_num + " states: ");
            for (int i = 0; i < state_num; i++) {
                total_cases = total_cases + daily_state_cases[i];
            }
            average_cases = (total_cases * 1.0) / state_num; // Multiply by 1.0 to force double arithmetic instead of integer arithmetic.
            System.out.println(average_cases + "\n");

            // Counts the number of green, yellow, and red zones and records them according to the state.
            for (int i = 0; i < state_num; i++) {
                if (daily_state_cases[i] < 99) {
                    zone_category[i] = "Green";
                } else if (daily_state_cases[i] <= 200) {
                    zone_category[i] = "Yellow";
                } else {
                    red_zone_counter++;
                    zone_category[i] = "Red";
                }
            }

            // Outputs the summary from data calculated above.
            System.out.println("Total red zones today: " + red_zone_counter);
            System.out.println("Final report for today: \n");
            System.out.println("State\t\tTotal Cases\tZone");
            for (int i = 0; i < state_num; i++) {
                System.out.println(state_name[i] + "\t\t" + daily_state_cases[i] + "\t\t" + zone_category[i]);
            }

            // Finds and prints the highest value from the daily_state_cases array.
            int highest_state_case = daily_state_cases[0];
            int highest_index = 0;
            for (int i = 1; i < state_num; i++) {
                if (daily_state_cases[i] > highest_state_case) {
                    highest_state_case = daily_state_cases[i];
                    highest_index = i;
                }
            }
            System.out.println("Highest number of cases of COVID-19 today\t: " + highest_state_case);
            System.out.print("State with the highest number of cases\t\t: " + state_name[highest_index]);
        }
    }
}