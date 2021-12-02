package app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.jooby.annotations.*;
import io.jooby.exception.*;

public class SomaTest {
    
    @Test
    public void somaTest_ok(){
        Soma sum = new Soma();
        assertEquals(4, sum.soma("2", "2"));
    }
}
