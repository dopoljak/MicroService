MicroService

   https://access.redhat.com/documentation/en-us/red_hat_openshift_application_runtimes/1/html/wildfly_swarm_runtime_guide/wildfly_swarm_fractions_reference
    https://github.com/eclipse/microprofile-open-api/blob/master/spec/src/main/asciidoc/microprofile-openapi-spec.adoc
    https://github.com/wildfly-swarm/wildfly-swarm-examples/tree/master/jpa-jaxrs-cdi/jpa-jaxrs-cdi-jta
    https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/content/getting-started/shrinkwrap.html
    https://github.com/wildfly-swarm/wildfly-swarm-examples/tree/master/flyway

    DATA SOURCE PROFILE (H2, POSTGRES ... )
    https://wildfly-swarm.gitbooks.io/wildfly-swarm-users-guide/configuration/command_line.html

    CONFIG:
    https://github.com/wildfly-swarm/wildfly-swarm-examples/tree/master/config-options



    TODO: research & test how to extract file from JAR za datasource - najedinostavniji test staviti ga u isti folder gdje je jar i pokrenuti sa -s parametrom!
    TODO: deployati WAR na pravi wildfly da se vidi oce se ovi moduli za database, datasource poklati ?
    TODO: external configuration - istražiti kako napraviti config za wildfly + wildfly swarm - predlažem da se config u wildfly nalazi u standalone/config ili koji vec lokacija a da se samo u web.xml kaže ime konfiguracije ...
    TODO: logiranje - externalizirati i vidjeti kako na oba nacina rješiti
    TODO: staviti barem jedan primjer integracijskog testa - ima ih hrpa u primjerima treba vidjeti malo što je najbojje ...
    TODO: implementirati jedan background job i sukladno tome počistiti smeče tamo u core service :D
    TODO: verzioniranje maven/pom pofixati (da su u rootu definirane sve verzije komponenti!)
    TODO: refaktorirati orderRequest i paging ili ih totalno replacati sa CommonBean ?? čini se da je full jednostavnije !