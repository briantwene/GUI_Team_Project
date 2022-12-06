/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import java.time.LocalDate;

/**
 *
 * @author twene
 */
public class beforeTodayVetoPolicy implements DateVetoPolicy {

    // overriding LGoodDatePicker veto policy
    @Override
    public boolean isDateAllowed(LocalDate date) {
        // check if the date is before the current date
        // if it is ....
        if (date.isBefore(LocalDate.now())) {

            // then prevent the user from selecting...
            return false;
        }

        // or leave it as is
        return true;
    }

}
