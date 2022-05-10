package edu.corvinus.HT_REST.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import static java.lang.Math.sqrt;

@RestController
public class GYOK {

    @RequestMapping("/elso")
    public String negyzetgyoker(@RequestParam(value = "gyok", defaultValue = "0") String gyok) {
        double temp = java.lang.Integer.parseInt(gyok);
        if (temp > 0) {
            temp = sqrt(temp);
            return "Az Ön által választott szám négyzetgyöke (kerekítve): " +
                    (double) Math.round(temp * 100) / 100 + "!";
        }
        if (temp < 0) {
            temp = (temp * (-1));
            temp = sqrt(temp);
            return "Az Ön által választott szám négyzetgyöke (kerekítve): " +
                    (double) Math.round(temp * 100) / 100 + "i!";
        }
        return "A 'gyok' paraméterrel tudja megadni, hogy melyik szám négyzetgyökére kíváncsi! (0 négyzetgyöke 0.)";
    }
}
