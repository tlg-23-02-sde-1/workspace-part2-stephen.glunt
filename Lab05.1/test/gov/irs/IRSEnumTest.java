/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package gov.irs;

import com.javatunes.corp.Corporation;
import org.junit.Test;
import static org.junit.Assert.*;

public class IRSEnumTest {

    @Test
    public void normalClientUsage() {
        IRS irs = IRS.getInstance();  // client can also say "IRSEnum.INSTANCE"
        irs.register(new Corporation("JavaTunes"));
        irs.collectTaxes();
    }

    /**
     * TASK: verify that two calls to IRSEnum.getInstance() return the same instance.
     */
    @Test
    public void getInstance_shouldReturnSameInstance_everyTime() {
        IRS irs1 = IRSEnum.INSTANCE;
        IRS irs2 = IRS.getInstance();
        assertTrue(irs1 == irs2);

        assertSame(irs1, irs2);

    }


}