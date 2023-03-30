package databaseconfig
import com.example.connection
import org.ktorm.database.Database
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Databasefactory {
  fun init(): Database {
    return Database.connect(hikari())
  }

  private fun hikari(): HikariDataSource {
    val config = HikariConfig()
    config.driverClassName = "com.mysql.cj.jdbc.Driver"
    config.jdbcUrl = "jdbc:mysql://localhost:3306/Ktorm"
    config.username = "root"
    config.password = "root"
    config.maximumPoolSize = 10
    config.isAutoCommit = false
    config.transactionIsolation = "TRANSACTION_REPEATABLE_READ"
    //config.transactionIsolation = "TRANSACTION_READ_COMMITTED"
    config.validate()
    return HikariDataSource(config)
  }

  suspend fun <T> dbQuery(block: () -> T): T = withContext(Dispatchers.IO) {
    getConnection().useTransaction {
      block()
    }
  }

  fun getConnection(): Database {
    return connection!!
  }
}
/*
object Databasefactory {
  val Driver= "com.mysql.cj.jdbc.Driver"
    val url ="jdbc:mysql://localhost:3306/ktorm"
    val userid ="root"
    val pass="root"
    val database = Database.connect(url,Driver,userid,pass)
}*/
