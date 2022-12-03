/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import com.github.lgooddatepicker.optionalusertools.DateVetoPolicy;
import java.time.LocalDate;

/**
 *
 * @author twene
 */
public class beforeTodayVetoPolicy implements DateVetoPolicy {

    @Override
    public boolean isDateAllowed(LocalDate date) {
        if (date.isBefore( LocalDate.now())) {

            return false;
        }
        
        return true;
    }

}
