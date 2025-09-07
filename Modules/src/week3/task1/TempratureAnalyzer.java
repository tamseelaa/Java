package week3.task1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class TempratureAnalyzer {
    public static void main(String[] args) {
        String urlString = "https://users.metropolia.fi/~jarkkov/temploki.csv";
        String line;
        double sum = 0;
        int count = 0;

        try {
            URL url = new URL(urlString);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));

            // Read header to find index of "UlkoTalo"
            String header = br.readLine();
            String[] columns = header.split(";");
            int ulkoIndex = -1;
            for (int i = 0; i < columns.length; i++) {
                if (columns[i].equalsIgnoreCase("UlkoTalo")) {
                    ulkoIndex = i;
                    break;
                }
            }

            if (ulkoIndex == -1) {
                System.out.println("Column UlkoTalo not found!");
                return;
            }

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length > ulkoIndex) {
                    String timestamp = parts[0]; // first column has date+time
                    if (timestamp.startsWith("01.01.2023")) { // only first day of January
                        try {
                            double temp = Double.parseDouble(parts[ulkoIndex].replace(",", "."));
                            sum += temp;
                            count++;
                        } catch (NumberFormatException e) {
                            // skip invalid entries
                        }
                    }
                }
            }

            if (count > 0) {
                System.out.println("Average temperature (1.1.2023, UlkoTalo): " + (sum / count));
            } else {
                System.out.println("No valid data found for 1.1.2023");
            }

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}