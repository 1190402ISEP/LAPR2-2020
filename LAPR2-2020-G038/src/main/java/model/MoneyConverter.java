package model;

import java.io.Serializable;

public class MoneyConverter implements MoneyConvertion , Serializable{

    String[] countries = {"Brasil", "European Union", "England", "South Africa", "India", "China", "South Korea", "USA", "Russia", "Australia", "Switzerland"};

    String[] currencies = {"Reais", "Euro", "Pound", "Rand", "Rupees", "Yuan", "Won", "Dollar", "Ruble", "Aus Dollar", "Franco"};

    double[] rates = {6, 1, 0.89, 19.32, 83.92, 7.94, 1364.47, 1.12, 76.91, 1.63, 1.07};

    @Override
    public double convert(String country, double cost) {

        for (int i = 0; i < countries.length; i++) {

            if (country.equalsIgnoreCase(countries[i])) {
                cost = cost * rates[i];
            }
        }
        return cost;
    }

}
