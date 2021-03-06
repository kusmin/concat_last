dataSource {
    pooled = true
    jmxExport = true
    driverClassName = 'com.mysql.jdbc.Driver'
    username = 'concot'
    password = 'concot'
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    //    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EnCacheRegionFactory' // Hibernate 4
    dialect = 'org.hibernate.dialect.MySQLInnoDBDialect'
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            dbCreate = 'update' // one of 'create', 'create-drop', 'update', 'validate', ''
            url = 'jdbc:mysql://localhost:3306/concot'
        }
    }
    test {
        dataSource {
            dbCreate = 'update'
            url = 'jdbc:mysql://localhost:3306/concot'
        }
    }
    production {
        dataSource {
            dbCreate = 'update'
            url = 'jdbc:mysql://192.168.2.20:3306/concot'
            properties {
                // See http://grails.org/doc/latest/guide/conf.html#dataSource for documentation
                // jmxEnabled = true
                // initialSize = 5
                maxActive = -1
                // minIdle = 5
                // maxIdle = 25
                // maxWait = 10000
                // maxAge = 10 * 60000
                timeBetweenEvictionRunsMillis = 180000
                minEvictableIdleTimeMillis = 180000
                numTestPerEvictionRun = 3
                validationQuery = 'SELECT 1'
                validationQueryTimeout = 3
                validationInterval = 15000
                testOnBorrow = true
                testWhileIdle = true
                testOnReturn = false
                jdbcInterceptors = 'ConnectionState'
                // defaultTransactionIsolation = java.sql.Connection.TRANSACTION_READ_COMMITTED
            }
        }
    }
}
