package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class Soma{

    @Path("/soma/{num1}/{num2}")
    @GET

    public String rotaSoma(@PathParam String num1, @PathParam String num2) {

        try {
            
            //Converter parâmetros (num1 e num2) para double:
            double numero1 = Double.parseDouble(num1);
            double numero2 = Double.parseDouble(num2);
            double soma = 0;

            //Calcular a soma dos dois números:
            soma = numero1 + numero2;

            //Retornar soma para o usuário:
            return String.format("%.2f", soma);
        
        } catch (NumberFormatException nfe) {

             /*
            Quando o formato dos parâmetros informados na URL não estiver correto, ocorrerá uma exceção
            que irá interromper o fluxo normal do programa.
            Por isso o NumberFormatException é lançado para indicar que a aplicação tentou converter a 
            string para double, mas como a string (parâmetro) informado não tinha o formato 
            apropriado não foi possível fazer a conversão, por isso é apresentada a mensagem
            "valores inválidos".
            */

            throw new BadRequestException(String.format("Valores inválidos (%s e %s)", num1, num2));
        }
    }
}