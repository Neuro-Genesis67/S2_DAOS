package example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JAVAexamples {

	/**
	 * @param args
	 */
	static Connection minConnection;
	static Statement stmt;
	static BufferedReader inLine;

	public static void selectudenparm() {
		try {
			// Laver sql-s�tning og f�r den udf�rt
			String sql = "select navn,stilling from person";
			System.out.println("SQL-streng er " + sql);
			ResultSet res = stmt.executeQuery(sql);
			// genneml�ber svaret
			while (res.next()) {
				String s;
				s = res.getString("navn");
				System.out.println(s + "    " + res.getString(2));
			}
			// p�n lukning
			if (!minConnection.isClosed())
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public static void selectmedparm() {
		try {
			// Indl�ser s�gestreng
			System.out.println("Indtast s�gestreng");
			String inString = inLine.readLine();
			// Laver sql-s�tning og f�r den udf�rt
			String sql = "select navn,stilling from person where navn like '" + inString + "%'";
			System.out.println("SQL-streng er " + sql);
			ResultSet res = stmt.executeQuery(sql);
			// genneml�ber svaret
			while (res.next()) {
				System.out.println(res.getString(1) + "    " + res.getString(2));
			}
			// p�n lukning
			if (!minConnection.isClosed())
				minConnection.close();
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

	public static void insertmedstring() {
		try {
			// indl�sning
			System.out.println("Vi vil nu oprette et nyt ans�ttelsesfforhold");
			System.out.println("Indtast cpr (personen skal v�re oprettet p� forh�nd");
			String cprstr = inLine.readLine();
			System.out.println("Indtast firmanr (firma skal v�re oprettet p� forh�nd");
			String firmastr = inLine.readLine();

			// sender insert'en til db-serveren
			String sql = "insert into ansati values ('" + cprstr + "'," + firmastr + ")";
			System.out.println("SQL-streng er " + sql);
			stmt.execute(sql);
			// p�nt svar til brugeren
			System.out.println("Ans�ttelsen er nu registreret");
			if (!minConnection.isClosed())
				minConnection.close();
		} catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{
			case 547: {
				if (e.getMessage().contains("cprforeign"))
					System.out.println("cpr-nummer er ikke oprettet");
				if (e.getMessage().contains("firmaforeign"))
					System.out.println("firmaet er ikke oprettet");
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
			case 2627: {
				System.out.println("den p�g�ldende ans�ttelse er allerede oprettet");
				break;
			}
			default:
				System.out.println("fejlSQL:  " + e.getMessage());
			}
			;
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	};

	public static void insertprepared() {
		try {
			// indl�sning
			System.out.println("Vi vil nu oprette et nyt ans�ttelsesfforhold");
			System.out.println("Indtast cpr (personen skal v�re oprettet p� forh�nd");
			String cprstr = inLine.readLine();
			System.out.println("Indtast firmanr (firma skal v�re oprettet p� forh�nd");
			String firmastr = inLine.readLine();
			// Anvendelse af prepared statement
			String sql = "insert into ansati values (?,?)";
			PreparedStatement prestmt = minConnection.prepareStatement(sql);
			prestmt.clearParameters();
			prestmt.setString(1, cprstr);
			prestmt.setInt(2, Integer.parseInt(firmastr));
			// Udf�rer s�tningen
			prestmt.execute();
			// p�nt svar til brugeren
			System.out.println("Ans�ttelsen er nu registreret");
			if (!minConnection.isClosed())
				minConnection.close();
		} catch (SQLException e) {
			switch (e.getErrorCode())
			// fejl-kode 547 svarer til en foreign key fejl
			{
			case 547: {
				if (e.getMessage().contains("cprforeign"))
					System.out.println("cpr-nummer er ikke oprettet");
				if (e.getMessage().contains("firmaforeign"))
					System.out.println("firmaet er ikke oprettet");
				break;
			}
			// fejl-kode 2627 svarer til primary key fejl
			case 2627: {
				System.out.println("den p�g�ldende ans�ttelse er allerede oprettet");
				break;
			}
			default:
				System.out.println("fejlSQL:  " + e.getMessage());
			}
			;
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			inLine = new BufferedReader(new InputStreamReader(System.in));
			// generel ops�tning
			// via native driver
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			minConnection = DriverManager.getConnection(
					"jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=eksempeldb;user=sa;password=123sql;");
			stmt = minConnection.createStatement();
			// Indl�sning og kald af den rigtige metode
			System.out.println("Indtast  ");
			System.out.println("s for select uden parameter  ");
			System.out.println("sp for select med parameter  ");
			System.out.println("i for insert med strengmanipulation");
			System.out.println("ps for insert med prepared statement ");
			String in = inLine.readLine();
			switch (in) {
			case "s": {
				selectudenparm();
				break;
			}
			case "sp": {
				selectmedparm();
				break;
			}
			case "i": {
				insertmedstring();
				break;
			}
			case "ps": {
				insertprepared();
				break;
			}
			default:
				System.out.println("ukendt indtastning");
			}
		} catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
