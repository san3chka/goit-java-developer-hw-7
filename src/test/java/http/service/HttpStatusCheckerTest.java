package http.service;

import exception.CatNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HttpStatusCheckerTest {

    @Test
    public void testCheckStatusCode_ValidCode() throws Exception {
        String expected = "https://http.cat/200.jpg";

        String actual = new HttpStatusChecker().getStatusImage(200);

        assertEquals(actual, expected);
    }

    @Test
    public void testCheckStatusCode_InvalidCode() {
        assertThrows(CatNotFoundException.class, () -> new HttpStatusChecker().getStatusImage(1000));
    }
}
