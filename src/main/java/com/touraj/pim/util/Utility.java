package com.touraj.pim.util;

import com.touraj.pim.domain.Category;

import java.util.List;
import java.util.Optional;

/**
 * Created by toraj on 08/12/2018.
 */
public class Utility {

    public static Optional<Category> findCategoryByID(List<Category> categories, long importedID){
        Optional<Category> category = categories
                .stream()
                .filter(c -> c.getCategoryid() == importedID)
                .findAny();
        return category;
    }

    public static boolean convertToBoolean(String value) {
        boolean returnValue = false;
        if ("1".equalsIgnoreCase(value) || "yes".equalsIgnoreCase(value) ||
                "true".equalsIgnoreCase(value) || "on".equalsIgnoreCase(value))
            returnValue = true;
        return returnValue;
    }

    public static int parsInt(String val) {
        int result = 0;
        try {
            result = Integer.parseInt(val);
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }

    public static double parsDouble(String val) {
        double result = 0;
        try {
            result = Double.parseDouble(val);
        } catch (NumberFormatException e) {
            return 0;
        }
        return result;
    }
}
