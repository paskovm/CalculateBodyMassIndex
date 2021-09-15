public class Main {

//    BMI("205 pounds", "73 inches") ➞ "27.0 Overweight"
//    BMI("55 kilos", "1.65 meters") ➞ "20.2 Normal weight"
//    BMI("154 pounds", "2 meters") ➞ "17.5 Underweight"

    public static void main(String[] args) {

        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(BMI("55 kilos", "1.65 meters"));
        System.out.println(BMI("154 pounds", "2 meters"));
    }

    private static String BMI(String weight, String height){
        double param1 = Double.parseDouble(weight.split("\\s")[0]);
        double param2 = Double.parseDouble(height.split("\\s")[0]);

        double index;
        String indexDef;

        if (weight.contains("pounds")) {
            param1 = translatePounds(param1);
        }
        if (height.contains("inches")) {
            param2 = translateInches(param2);
        }

        index = calcIndex(param1, param2);

        if (index < 18.5) {
            indexDef = "Underweight";
        } else if (index > 18.5 && index < 24.9) {
            indexDef = "Normal weight";
        } else if (index > 25 && index < 29.9) {
            indexDef = "Overweight";
        } else {
            indexDef = "Obesity";
        }

        return String.format("%.1f", index) + " " + indexDef;
    }

    private static double calcIndex(double weight, double height) {
        return (weight / (height * height));
    }

    private static double translatePounds(double weight) {
        return weight * 0.453592;
    }

    private static double translateInches(double height) {
        return height * 0.0254;
    }
}
