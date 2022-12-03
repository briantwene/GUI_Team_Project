/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Components;

import com.github.lgooddatepicker.optionalusertools.TimeVetoPolicy;
import java.time.LocalTime;

/**
 *
 * @author twene
 */
public class beforeThisTimePolicy implements TimeVetoPolicy {

    @Override
    public boolean isTimeAllowed(LocalTime time) {
        if (time.isBefore(LocalTime.now())) {
            return false;

        }
        return true;

    }
}
