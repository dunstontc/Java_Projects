import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CommissionReport {
    private void run() throws FileNotFoundException {
        Scanner input= new Scanner(new File("project5.data"));
        final int employeeCount= 20;

        /* Allocate storage for IDs and commissions. */
        int[] ids= new int[employeeCount];
        double[] commissions= new double[employeeCount];

        /* Read the employee data and add the commission values. */
        double totalCommission= 0.0;
        for(int index= 0; index < 20; index += 1){
            ids[index]= input.nextInt();
            commissions[index]= input.nextDouble();
            totalCommission += commissions[index];
        }

        /* Compute and report the average commission. */
        double averageCommission= totalCommission/employeeCount;
        System.out.println("Average commission= "+averageCommission);

        /* OK... report those employees with commission > average. */
        System.out.println();
        System.out.println("Employees with commissions > average:");
        // *********** Add code here. ************ //
    }

    public static void main(String[] args) throws FileNotFoundException {
        CommissionReport application = new CommissionReport();
        application.run();
    }
}
