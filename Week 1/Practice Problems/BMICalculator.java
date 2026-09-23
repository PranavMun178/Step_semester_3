public class BMICalculator {

    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) {
            return "Normal";
        } else if (bmi < 30.0) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-10s | %-10s | %-11s | %-8s | %-12s%n", "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < heights.length; i++) {
            double h = heights[i];
            double w = weights[i];
            double bmi = w / (h * h);
            String status = getBmiStatus(bmi);

            System.out.printf("Person %-3d | %-10.2f | %-11.2f | %-8.2f | %-12s%n", 
                    (i + 1), h, w, bmi, status);
        }
        System.out.println("---------------------------------------------------------------");
    }

    public static void main(String[] args) {
        // Sample data for a team of employees
        double[] heights = {1.75, 1.60, 1.80, 1.65, 1.70, 1.55, 1.85, 1.68, 1.72, 1.62};
        double[] weights = {70.0, 90.0, 65.0, 80.0, 50.0, 68.0, 95.0, 72.0, 60.0, 42.0};

        printWellnessReport(heights, weights);
    }
}