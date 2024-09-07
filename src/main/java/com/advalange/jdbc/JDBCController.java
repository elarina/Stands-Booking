package com.advalange.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.advalange.model.Employee;
import com.advalange.model.Stand;

public class JDBCController {
	private DataSource dataSource;

	public JDBCController(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public List<Stand> queryStands() {
		List<Stand> stands = new ArrayList<Stand>();

		String sql = "SELECT id, name, ip, username, password, busy FROM stands;";

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
				boolean busy = rs.getBoolean(6);
				stands.add(new Stand(id, name, ip, username, password, busy));
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
		String sql = "SELECT id, firstname, lastname FROM employees;";
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
				String lastname = rs.getString(3);
				employees.add(new Employee(id, name, lastname));
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
		String sql = "DELETE FROM stands where id = ?;";
		PreparedStatement statement = null;
		Connection connection = null;
		try {
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
		}
	}

	public void removeEmployee(int id) {
		String sql = "DELETE FROM employees where id = ?;";
		PreparedStatement statement = null;
		Connection connection = null;
		try {
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
		}
	}

	public void addStand(Stand stand) {
		PreparedStatement statement = null;
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			statement = connection.prepareStatement(
					"INSERT INTO stands (name, ip, username, password, busy) values (?, ?, ?, ?, ?);");
			statement.setString(1, stand.getName());
			statement.setString(2, stand.getIp());
			statement.setString(3, stand.getUsername());
			statement.setString(4, stand.getPassword());
			statement.setBoolean(5, stand.getBusy());
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
			statement = connection.prepareStatement("INSERT INTO employees (firstname, lastname) values (?, ?);");
			statement.setString(1, employee.getName());
			statement.setString(2, employee.getLastname());
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