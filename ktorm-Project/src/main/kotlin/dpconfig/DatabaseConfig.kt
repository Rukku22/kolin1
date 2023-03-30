package dpconfig

import org.ktorm.database.Database

object DatabaseConfig {
    val Driver= "com.mysql.cj.jdbc.Driver"
    val url ="jdbc:mysql://localhost:3306/ktorm"
    val userid ="root"
    val pass="root"
    val database = Database.connect(url,Driver,userid,pass)
}