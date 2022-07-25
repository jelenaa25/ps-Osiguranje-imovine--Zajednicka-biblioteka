/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validator;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 *
 * @author Korisnik
 */
public class Validator {

    private final List<String> validationErros;

    private Validator() {
        validationErros = new ArrayList();
    }

    public static Validator startValidation() {
        return new Validator();
    }

    public Validator validateNotNullOrEmpty(String value, String errorMessage) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public Validator validateNotNull(Object value, String errorMessage) throws ValidationException {
        if (value == null) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public Validator validateValueIsNumber(String value, String errorMessage) throws ValidationException {
        try {
            if (value != null && !value.trim().isEmpty()) {
                BigDecimal v = new BigDecimal(value);
                BigDecimal nula = new BigDecimal(0);
                if (v.compareTo(nula) == 0 || v.compareTo(nula) == -1) {
                    this.validationErros.add(errorMessage);
                }
            }
            /*else {
                this.validationErros.add(errorMessage);
            }*/
        } catch (NumberFormatException nfe) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public Validator validateValueIsDate(String value, String pattern, String errorMessage) throws ValidationException {
        try {
            if (value != null && !value.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                sdf.parse(value);
            }
            /*else {
                this.validationErros.add(errorMessage);
            }*/
        } catch (ParseException ex) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public Validator validateTwoDate(String value, String value2, String pattern, String errorMessage) throws ValidationException {
        try {
            if (value != null && !value.isEmpty()) {
                SimpleDateFormat sdf = new SimpleDateFormat(pattern);
                Date prvi = sdf.parse(value);
                if (value2 != null && !value.isEmpty()) {
                    SimpleDateFormat sdf1 = new SimpleDateFormat(pattern);
                    Date drugi = sdf1.parse(value2);
                    long diff = Math.abs(drugi.getTime() - prvi.getTime());
                    long dani =  TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
                    if (prvi.compareTo(drugi) >= 0) {
                        throw new ValidationException(errorMessage+"DatumOd mora biti pre DatumaDo. ");
                    } else if (dani < 365) {
                        throw new ValidationException(errorMessage+"Polisa mora biti najmanje na godinu dana.");
                    }

                }

            }
        } catch (ParseException | ValidationException ex) {
            if (ex instanceof ValidationException) {
                this.validationErros.add(ex.getMessage());
            }
        }
        return this;
    }

    public Validator validateListIsNotEmpty(List list, String errorMessage) throws ValidationException {
        if (list == null || list.isEmpty()) {
            this.validationErros.add(errorMessage);
        }
        return this;
    }

    public void throwIfInvalide() throws ValidationException {
        if (!validationErros.isEmpty()) {
            throw new ValidationException(this.validationErros.stream().collect(Collectors.joining("\n")));
        }
    }

    public Validator validateJMBGDuzina(String text, String errorMessage) {
        if (!text.isEmpty() && text != null) {
            if (text.length() == 13) {

                for (int i = 0; i < 13; i++) {
                    char c = text.charAt(i);
                    if (Character.isDigit(c) == false) {
                        this.validationErros.add(errorMessage);
                        return this;
                    }
                }
            } else {
                this.validationErros.add(errorMessage);
            }
        }
        return this;
    }

    public Validator validatePort(String port, String errorMessage) {
        try {
            int port1 = Integer.parseInt(port);

            if (port1 > 0 && (port1 > 65535 || port1 < 1025)) {
                this.validationErros.add(errorMessage);
            }
        } catch (NumberFormatException ex) {

        }

        return this;
    }

}
