package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Subtracao{

    @Path("/subtracao/{num1}/{num2}")
    @GET

    public String rotaSubtracao(@PathParam String num1, @PathParam String num2) {

        try {
            
            //Converter parâmetros (num1 e num2) para double:
            double numero1 = Double.parseDouble(num1);
            double numero2 = Double.parseDouble(num2);
            double subtracao = 0;

            //Calcular a subtracao dos dois números:
            subtracao = numero1 - numero2;

            //Retornar subtracao para o usuário:
            return String.format("%.2f", subtracao);
        
        } catch (NumberFormatException nfe) {
            throw new BadRequestException(String.format("Valores inválidos (%s e %s)", num1, num2));
        }
    }
}