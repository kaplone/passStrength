package fr.acelys.passStrength;

import java.util.HashMap;
import java.util.Map;

public class PassResponseDto {
    private Map<String, Integer> passValues = new HashMap<>();

    public Map<String, Integer> getPassValues() {
        return passValues;
    }

    public void setPassValues(Map<String, Integer> passValues) {
        this.passValues = passValues;
    }

    @Override
    public String toString() {
        return "passValues=" + passValues;
    }
}
