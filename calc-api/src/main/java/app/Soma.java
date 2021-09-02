package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma{

    @Path("/soma/{num1}/{num2}")
    @GET

    public String rotaSoma(@PathParam String num1, @PathParam String num2) {

        try {
            
            //Converter números para double (verificar erros):
            double numero1 = Double.parseDouble(num1);
            double numero2 = Double.parseDouble(num2);
            double sum = 0;

            //Calcular a soma dos dois números:
            sum = numero1 + numero2;

            //Retornar soma para o usuário:
            return String.format("%.2f", sum);

        } catch (NumberFormatException nfe) {
            throw new BadRequestException(String.format("Valores inválidos (%s e %s)", num1, num2));
        }
    }
}