dataSource {
    pooled = true
    driverClassName = "org.h2.Driver"
    username = "sa"
    password = ""
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = true
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = "update"
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            url = "jdbc:postgresql://localhost:5432/newNest5DB3"
            username = "postgres"
            password = "qtagtech"
        }
    }
    staging {
        dataSource {
            /*
            * REMOTE
            * */
            dbCreate = "update"
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            host = System.env.OPENSHIFT_POSTGRESQL_DB_HOST
            port = System.env.OPENSHIFT_POSTGRESQL_DB_PORT
            url = "jdbc:postgresql://"+host+":"+port+"/"+System.env.OPENSHIFT_APP_NAME
            username = System.env.OPENSHIFT_POSTGRESQL_DB_USERNAME
            password = System.env.OPENSHIFT_POSTGRESQL_DB_PASSWORD
            /*
            * LOCAL USAR CUANDO SE QUIERA EJECUTAR ESTE EN OCAL CONECTADO A BIGDATA EN SERVIDOR REMOTO STAGING
            * */

            /*dbCreate = "update"
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            url = "jdbc:postgresql://localhost:5432/newNest5DB3"
            username = "postgres"
            password = "qtagtech"*/
         }
    }
    production {
        dataSource {
            dbCreate = "update"
            driverClassName = "org.postgresql.Driver"
            dialect = "org.hibernate.dialect.PostgreSQLDialect"
            host = System.env.OPENSHIFT_POSTGRESQL_DB_HOST
            port = System.env.OPENSHIFT_POSTGRESQL_DB_PORT
            url = "jdbc:postgresql://"+host+":"+port+"/"+System.env.OPENSHIFT_APP_NAME
            username = System.env.OPENSHIFT_POSTGRESQL_DB_USERNAME
            password = System.env.OPENSHIFT_POSTGRESQL_DB_PASSWORD
        }
    }
}

