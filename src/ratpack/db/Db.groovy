package db

import groovy.transform.CompileStatic
import groovy.sql.Sql
import groovy.sql.GroovyResultSet
import com.zaxxer.hikari.*


class Db {

  public static List read(Sql sql, String query){
    sql.rows(query).grep().collect{it.values()}
  }

  public static void create(Sql sql, String query){
    sql.execute(query)
  }

  public static void update(Sql sql, String query){
    sql.executeUpate(query)
  }

  public static def find(Sql sql, String query){
    read(sql,query)?.first()
  }

}