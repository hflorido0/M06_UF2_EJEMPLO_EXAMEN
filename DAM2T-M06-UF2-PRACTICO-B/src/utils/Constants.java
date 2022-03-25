package utils;

public class Constants {
	
	public static final String SCHEMA_NAME = "StucomDam2t";
	public static final String CONNECTION = 
			"jdbc:mysql://localhost:3306/" + 
			SCHEMA_NAME + 
			"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
	public static final String USER_CONNECTION = "root";
	public static final String PASS_CONNECTION = "root";
	
	public static final String GET_ALL_ENTRADA = "Select * from Entrada";
	public static final String DELETE_ENTRADA = "delete from Entrada where entrada like '%USA%'";
	public static final String INSERT_ENTRADA = "insert into Entrada (entrada) values (?)";
}
