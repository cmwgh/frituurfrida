package be.vdab.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import be.vdab.entities.GastenBoekEntry;

public class GastenboekRepository extends AbstractRepository {
	private final static String FIND_ALL = "select id,naam,datumtijd,bericht from gastenboek order by id desc";
	private final static String CREATE = "insert into gastenboek(naam,datumtijd,bericht) values (?,?,?)";
	private final static String DELETE = "delete from gastenboek where id in (";
	
	public List<GastenBoekEntry> findAll() {
		try (Connection connection = dataSource.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(FIND_ALL)) {
			List<GastenBoekEntry> entries = new ArrayList<>();
			while (resultSet.next()) {
				entries.add(resultSetRijNaarGastenboekEntry(resultSet));
			}
			return entries;
		} catch (SQLException ex) {
			throw new RepositoryException(ex);
		}
	}

	public void create(GastenBoekEntry entry) {
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(CREATE)) {
			statement.setString(1, entry.getNaam());
			statement.setDate(2, java.sql.Date.valueOf(entry.getDatum()));
			statement.setString(3, entry.getBericht());
			statement.executeUpdate();
		} catch (SQLException ex) {
			throw new RepositoryException(ex);
		}
	}

	public void delete(Set<Long> ids) {
		StringBuilder sql = new StringBuilder(DELETE);
		ids.forEach(id -> sql.append("?,"));
		sql.deleteCharAt(sql.length() - 1);
		sql.append(')');
		try (Connection connection = dataSource.getConnection();
		PreparedStatement statement =
		connection.prepareStatement(sql.toString())) {
		int index = 1;
		for (long id : ids) {
		statement.setLong(index++, id);
		}
		statement.executeUpdate();
		} catch (SQLException ex) {
		throw new RepositoryException(ex);
		}
		}
	
	private GastenBoekEntry resultSetRijNaarGastenboekEntry(ResultSet resultSet) throws SQLException {
		return new GastenBoekEntry(resultSet.getLong("id"), resultSet.getString("naam"),
				resultSet.getDate("datumtijd").toLocalDate(), resultSet.getString("bericht"));
	}
}