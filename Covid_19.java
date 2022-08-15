import java.util.Scanner;

public class Covid_19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] statename= {"Perak", "Selangor", "Negeri Sembilan", "Pahang", "Johor", "Kedah", "Kelantan", "Terengganu",
                "Sabah", "Sarawak", "Perlis", "Pulau Pinang", "Melaka", "Kuala Lumpur"};
        int [] totalcase= new int [14];
        int red=0, yellow=0;
        int maximum_cases = 0; int e = 0;

        for (int i = 0; i < statename.length; i++)
        {
            System.out.print( " Enter the total cases in that " + statename[i] + " state : " );
            totalcase[i] = sc.nextInt();
        }
        for (int i = 0; i < statename.length; i++) {
            if ( totalcase[i] >= 1 && totalcase[i] <= 40 )
                yellow += totalcase[i];
            else
                red += totalcase[i];
        }
        for (int i = 0; i < statename.length; i++) {
            if (totalcase[i] > maximum_cases)
            {
            maximum_cases = totalcase[i];
            e = i;
            }
        }
        System.out.println("The highest number of cases is " + maximum_cases + " in " + statename[e]);
        System.out.println ( "The total number of cases in Green zone is 0 case." );
        System.out.println ( "The total number of cases in Yellow zone is " + yellow + " case." );
        System.out.println ( "The total number of cases in Red zone is " + red + " case." );
    }
}

