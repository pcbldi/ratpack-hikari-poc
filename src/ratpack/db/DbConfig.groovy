package db

import groovy.transform.CompileStatic
import groovy.sql.Sql
import com.zaxxer.hikari.*


class DbConfig {

  static DbConfig instance;
  HikariConfig config;
  HikariDataSource dataSource;

  private DbConfig(Properties props){
    config = new HikariConfig(props);
    dataSource = new HikariDataSource(config);
    instance=this;
  }


  static def getConnection (Properties properties){
    def db = this.getDbObject(properties);
    def connection = db.dataSource.connection
    connection.setAutoCommit(false);
    new Sql(connection)
  }

  static def wrapInTransaction(Closure closure){
    def sql= getConnection(getDbproperties());
    makeDbTransaction(sql,closure)
  }

  static def makeDbTransaction(Sql sql, Closure closure){
    try{
      def result=closure(sql);
      sql.commit();
      return result;
    }
    catch(Exception e){
      println "Exception----------------E"
      e.printStackTrace();
      sql.rollback();
    }
  }

  static def getDbObject(Properties properties){
    if(instance){
      return instance;
    }
    return new DbConfig(properties);
  }

  static def wrapInTestTransaction(Closure closure){
    def sql= getConnection(getTestDbProperties());
    makeDbTransaction(sql,closure)
  }

  //These proprites will be pulled from environment files later.
  static Properties getDbProperties(){
    Properties props = new Properties();
    props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
    props.setProperty("dataSource.user", "oracle");
    props.setProperty("dataSource.password", "oracle");
    props.setProperty("dataSource.portNumber", "5438");
    props.setProperty("dataSource.databaseName", "oracle");
    props.put("dataSource.logWriter", new PrintWriter(System.out));
    props
  }

  static Properties getTestDbProperties(){
    Properties props = new Properties();
    props.setProperty("dataSourceClassName", "org.postgresql.ds.PGSimpleDataSource");
    props.setProperty("dataSource.user", "oracle");
    props.setProperty("dataSource.password", "oracle");
    props.setProperty("dataSource.portNumber", "5438");
    props.setProperty("dataSource.databaseName", "oracle_test");
    props.put("dataSource.logWriter", new PrintWriter(System.out));
    props
  }

}