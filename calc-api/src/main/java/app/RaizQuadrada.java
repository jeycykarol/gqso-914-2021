package app;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class RaizQuadrada{

    @Path("/raiz/{op}")
    @GET

    public String rotaRaizQuadrada(@PathParam String op) {

        try {
            
            //Converter op para double (verificar erros):
            //Calcular a raiz quadrada
            double sqrt = Math.sqrt(Double.parseDouble(op));

            //Retornar raiz quadrada para o usuário com duas casas decimais;
            return String.format("%.2f", sqrt);

        } catch (NumberFormatException nfe) {
            throw new BadRequestException(String.format("Parâmetro inválido: %s", op));
        }
    }
}