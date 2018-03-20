package com.example.demo.initialization;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

//
// TODO: iz nekoga razloga ne želi ucitati ovo iz CoreService package-a!
// provijeriti zašto! - mislim da je bolje da sve klase isto imaju, možda eventualno da apstract naslijeđujemo
//
@ApplicationPath("/api")
public class JaxRsActivator extends Application {

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JaxRsActivator.class);

    public JaxRsActivator() {
        LOGGER.info(">> JaxRsActivator()");
        LOGGER.info("Service activator : @ApplicationPath('/api') ...");
        LOGGER.info("<< JaxRsActivator()");
    }

}
