package com.larina.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.larina.model.Employee;
import com.larina.model.Stand;

public class JDBCController {
	private DataSource dataSource;
	
	private static final String UNDERLINE = "_";
	private static final String DEFAULT_PASSWORD = "12345";
	

	public JDBCController(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Stand> queryStands() {
		List<Stand> stands = new ArrayList<Stand>();

		String sql = "SELECT id, name, ip, username, password FROM stands;";

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String ip = rs.getString(3);
				String username = rs.getString(4);
				String password = rs.getString(5);
				stands.add(new Stand(id, name, ip, username, password));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return stands;
	}

	public List<Employee> queryEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		String sql = "SELECT username, name, lastname FROM employees;";
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();
			while (rs.next()) {
				String username = rs.getString(1);
				String name = rs.getString(2);
				String lastname = rs.getString(3);
				employees.add(new Employee(username, name, lastname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
//		List<Map<String, Object>> records = jdbcTemplate.queryForList(sql);
//
//		for (Map<String, Object> record : records) {
//			int id = (int) record.get("id");
//			String name = (String) record.get("firstname");
//			String lastname = (String) record.get("lastname");
//			employees.add(new Employee(id, name, lastname));
//		}

		return employees;
	}

	public void removeStand(int id) {
		String sql_statuses =  "DELETE from statuses where FK_stands = ?";
		String sql = "DELETE FROM stands where id = ?;";
		PreparedStatement statementStatuses = null;
		Connection connectionStatuses = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connectionStatuses = dataSource.getConnection();
			statementStatuses = connectionStatuses.prepareStatement(sql_statuses);
			statementStatuses.setInt(1, id);
			statementStatuses.executeUpdate();
			
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (statementStatuses != null) {
				try {
					statementStatuses.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connectionStatuses != null) {
				try {
					connectionStatuses.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void removeEmployee(String username) {
		String sql_statuses =  "DELETE from statuses where FK_employees = ?";
		String sql = "DELETE FROM employees where username = ?;";
		PreparedStatement statement_statuses = null;
		Connection connection_statuses = null;
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection_statuses = dataSource.getConnection();
			statement_statuses = connection_statuses.prepareStatement(sql_statuses);
			statement_statuses.setString(1, username);
			statement_statuses.executeUpdate();
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if (statement_statuses != null) {
				try {
					statement_statuses.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection_statuses != null) {
				try {
					connection_statuses.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void addStand(Stand stand) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO stands (name, ip, username, password) values (?, ?, ?, ?);");
			statement.setString(1, stand.getName());
			statement.setString(2, stand.getIp());
			statement.setString(3, stand.getUsername());
			statement.setString(4, stand.getPassword());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public void addEmployee(Employee employee) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement("INSERT INTO employees (username, password, enabled, name, lastname) values (?, ?, ?, ?, ?);");
			statement.setString(1, employee.getName().toLowerCase() + UNDERLINE + employee.getLastname().toLowerCase());
			statement.setString(2, DEFAULT_PASSWORD);
			statement.setBoolean(3, true);
			statement.setString(4, employee.getName());
			statement.setString(5, employee.getLastname());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}
}