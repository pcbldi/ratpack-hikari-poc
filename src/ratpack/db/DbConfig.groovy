package db

import groovy.transform.CompileStatic
import groovy.sql.Sql
import com.zaxxer.hikari.*


class DbConfig {

  static DbConfig instance;
  HikariConfig config;
  HikariDataSource dataSource;

  private DbConfig(){
    Properties props = new Properties();
    props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
    props.setProperty("dataSource.user", "oracle");
    props.setProperty("dataSource.password", "oracle");
    props.setProperty("dataSource.portNumber", "5438");
    props.setProperty("dataSource.databaseName", "oracle");
    props.put("dataSource.logWriter", new PrintWriter(System.out));
    config = new HikariConfig(props);
    dataSource = new HikariDataSource(config);
    instance=this;
  }


  static def getConnection (){
    def db = this.getDbObject();
    new Sql(db.dataSource);
  }

  static def wrapInTransaction(Closure closure){
    def sql= this.getConnection();
    sql.withTransaction(closure);
  }

  static def getDbObject(){
    if(instance){
      return instance;
    }
    return new DbConfig();
  }

}