package db

import groovy.transform.CompileStatic
import groovy.sql.Sql


class DbConfig {
  static def getSqlInstance(){
    def dbUrl      = "jdbc:postgresql://localhost:5438/oracle"
    def dbUser     = "french_castle"
    def dbPassword = "test"
    def dbDriver   = "org.postgresql.Driver"
    return Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)
  }
}