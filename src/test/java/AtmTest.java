
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gsuhocki on 9/30/15.
 */
public class AtmTest {

    @Test
    public void withDrawlTest() {
        Atm atm=new Atm();
        Atm.Account account1 = atm.getAccount1();
        Atm.Transaction transaction1 = atm.getTransaction1();
        atm.withDrawl(20);
        assertEquals("The effect the with drawl has on the balance", 480, account1.getBalance());
        assertEquals("The effect the with drawl has on the balance","banans",transaction1.getRecord());
    }

}
