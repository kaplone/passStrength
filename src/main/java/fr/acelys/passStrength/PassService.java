package fr.acelys.passStrength;

import fr.acelys.passStrength.RandomGeneration.RandomPassWord;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class PassService {

    public List<String> getPass(int length, int count) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; i++){
            String pass = RandomPassWord.newString(length);
            list.add(pass);
        }
        return list;
    }

}
