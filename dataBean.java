﻿package org.hz.hrm.db;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class dataBean {
	private Connection conn = null; // 連接
	private boolean oldCommit; // 原連接提交方式
	private static DataSource ds = null; // 數據集
	private Statement st = null;
	private PreparedStatement pst = null;
	private CallableStatement cst = null;
	private ResultSetMetaData rsmt = null;
	private Vector pstmtList = new Vector();
	private Vector cstmtList = new Vector();
	private ResultSet rs = null;
	Logger log = Logger.getLogger(this.getClass().getName());
	private String jndi = "java:comp/env/Score";

	// 構造方法
	public dataBean() {
		// System.out.println("Create db " + new Date());
	}

	public dataBean(String jndi) {

		this.jndi = jndi;
	}

	// 取出DataSource
	public DataSource getDataSource() throws SQLException {
		try {
			InitialContext ctx = new InitialContext();
			if (ds == null) {
				ds = (DataSource) ctx.lookup(jndi);
			}
			// System.out.println(" 測試 Jndi 數據連接 "+jndi);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new SQLException(e.getMessage());
		}
		return ds;
	}

	// 創建並返回連接
	public Connection getConn() throws SQLException {
		try {
			if (ds == null) {
				ds = getDataSource();
			}
			conn = ds.getConnection();
			// conn = getConn("jdbc");
			// System.out.println("!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 創建連接並回連接
	public Connection getConn(String defaultNoUse) throws SQLException {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@10.105.33.88:1521:pakeyfan", "sz", "sz");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 設置連接提交方式
	public void setCommit(boolean newCommit) throws SQLException {
		try {
			if (conn == null || conn.isClosed()) {
				conn = getConn();
			}
			oldCommit = conn.getAutoCommit();
			conn.setAutoCommit(newCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 還原最近一次的提交方式
	public void backCommit() throws SQLException {
		try {
			conn.setAutoCommit(oldCommit);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 關閉連接
	public void closeConn() throws SQLException {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
				// System.out.print("Close conn " + conn + new Date());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 創建Statement並返回
	public Statement getSt() throws SQLException {
		try {
			if (conn == null) {
				conn = getConn();
			}
			st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;
	}

	// 關閉Statement
	public void closeSt() {
		try {
			if (st != null) {
				st.close();
				// System.out.print("Close st " + st + new Date());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 創建PreparedStatement並返回1
	public PreparedStatement getPst(String sql) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			pst = conn.prepareCall(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst;
	}

	// 創建PreparedStatement並返回2
	public PreparedStatement getPst(String sql, int autoGeneratedKeys) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			pst = conn.prepareStatement(sql, autoGeneratedKeys);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst;
	}

	// 創建PreparedStatement並返回3
	public PreparedStatement getPst(String sql, int resultSetType,
			int resultSetConcurrency) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			pst = conn.prepareStatement(sql, resultSetType,
					resultSetConcurrency);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst;
	}

	// 創建PreparedStatement並返回4
	public PreparedStatement getPst(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			pst = conn.prepareStatement(sql, resultSetType,
					resultSetConcurrency, resultSetHoldability);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst;
	}

	// 創建PreparedStatement並返回5
	public PreparedStatement getPst(String sql, int[] columnIndexed) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			pst = conn.prepareStatement(sql, columnIndexed);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst;
	}

	// 創建PreparedStatement並返回6
	public PreparedStatement getPst(String sql, String[] columnNames) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			pst = conn.prepareStatement(sql, columnNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pst;
	}

	// 付執行參數
	public void setParam(int paramIndex, Object object) throws SQLException {
		try {
			pst.setObject(paramIndex, object);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setParam(int paramIndex, float paramValue) throws SQLException {
		try {
			pst.setFloat(paramIndex, paramValue);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	// 關閉PreparedStatement
	public void closePst() {
		try {
			if (pst != null) {
				pst.close();
				// System.out.print("Close pst " + pst + new Date());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 創建CallableStatement.1
	public CallableStatement getCst(String sql) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			cst = conn.prepareCall(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cst;
	}

	// 創建CallableStatement.2
	public CallableStatement getCst(String sql, int resultSetType,
			int resultSetConcurrency) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			cst = conn.prepareCall(sql, resultSetType, resultSetConcurrency);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cst;
	}

	// 創建CallableStatement.3
	public CallableStatement getCst(String sql, int resultSetType,
			int resultSetConcurrency, int resultSetHoldability) {
		// this.log(sql);
		try {
			if (conn == null) {
				conn = getConn();
			}
			cst = conn.prepareCall(sql, resultSetType, resultSetConcurrency,
					resultSetHoldability);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cst;
	}

	// 付執行參數
	public void setcstParam(int paramIndex, Object object) throws SQLException {
		try {
			cst.setObject(paramIndex, object);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setcstParam(int paramIndex, String paramValue)
			throws SQLException {
		try {
			cst.setString(paramIndex, paramValue);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setcstParam(int paramIndex, float paramValue)
			throws SQLException {
		try {
			cst.setFloat(paramIndex, paramValue);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setcstParam(String paramName, Object object)
			throws SQLException {
		try {
			cst.setObject(paramName, object);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void setcstParam(String paramName, float paramValue)
			throws SQLException {
		try {
			cst.setFloat(paramName, paramValue);
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void registOutValue(int paramIndex, int paramStyle)
			throws SQLException {
		try {
			cst.registerOutParameter(paramIndex, paramStyle);
		} catch (SQLException e) {
			throw e;
		}
	}

	public void regitstOutValue(String paramName, int paramStyle)
			throws SQLException {
		try {
			cst.registerOutParameter(paramName, paramStyle);
		} catch (SQLException e) {
			throw e;
		}
	}

	public Object getRegValue(int paramIndex) throws SQLException {
		try {
			return cst.getObject(paramIndex);
		} catch (SQLException e) {
			throw e;
		}
	}

	// 關閉CallableStatement
	public void closeCst() {
		try {
			if (cst != null) {
				cst.close();
				// System.out.print("Close cst " + cst + new Date());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 執行更新SQL語句
	public boolean update(String sql) throws SQLException, NullPointerException {
		this.log(sql);
		// WriteLogFile writeLog = new WriteLogFile();
		// writeLog.WriteLog("/hrm/hrmsqllog/updateLog.log","UpdateSql = " + sql
		// + " UpdateDate = " + new Date());
		if (st == null) {
			st = getSt();
		}
		return st.execute(sql);
	}

	// leijun add
	// 返回受影響的記錄條數 -1為執行失敗
	public int executeUpdate(String sql) throws SQLException,
			NullPointerException {
		this.log(sql);
		// WriteLogFile writeLog = new WriteLogFile();
		// writeLog.WriteLog("/hrm/hrmsqllog/updateLog.log","UpdateSql = " + sql
		// + " UpdateDate = " + new Date());
		if (st == null) {
			st = getSt();
		}
		return st.executeUpdate(sql);
	}

	// 提交當前的操作
	public void commitExe() throws SQLException, NullPointerException {
		if (conn != null && !conn.isClosed() && !conn.getAutoCommit()) {
			conn.commit();
		}
	}

	// 回滾當前的操作
	public void rollbackExe() throws SQLException, NullPointerException {
		if (conn != null && !conn.isClosed() && !conn.getAutoCommit()) {
			conn.rollback();
		}
	}

	// 執行SQL處理查詢
	public void exeQuery(String sql) throws SQLException, NullPointerException {
		this.log(sql);
		// WriteLogFile writeLog = new WriteLogFile();
		// writeLog.WriteLog("/hrm/hrmsqllog/selectLog.log","SelectSql = " + sql
		// + " SelectDate = " + new Date());
		if (st == null) {
			st = getSt();
		}
		rs = st.executeQuery(sql);
		rsmt = rs.getMetaData();
		// System.out.println(sql);
	}

	// 執行PST處理
	public int exePst() throws SQLException, NullPointerException {
		return pst.executeUpdate();
	}

	// 執行CST處理
	public int exeCst() throws SQLException, NullPointerException {
		return cst.executeUpdate();
	}

	// 取結果集
	public ResultSet getRs() {
		return rs;
	}

	// 取ResultSetMetadata集
	public ResultSetMetaData getRsmt() {
		return rsmt;
	}

	// 關閉結果集
	public void closeRs() throws SQLException {
		try {
			if (rs != null) {
				rs.close();
				// System.out.print("Close rs " + rs + new Date());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 關閉所有存在的結果集、連接等
	public void close() throws SQLException {
		try {
			// System.out.print("fyh1");
			this.closeCst();
			// System.out.print("fyh2");
			this.closePst();
			// System.out.print("fyh3");
			this.closeSt();
			// System.out.print("fyh4");
			this.closePrst();
			this.closeConn();
			// System.out.print("fyh5");
			// System.out.println("!!!!");
		} catch (SQLException e) {
			// e.printStackTrace();
		}
	}

	// leijun add 用於有條件的預編譯sql 5/29
	public int pstmtUpdate(String sql, String param) throws SQLException {
		String[] params = param.split(",");
		// this.sqlErrLog("normalSql",param,sql);
		return this.pstmtUpdate(sql, params);
	}

	// 執行具有IN型參數的Update/Delete/Insert與DDL語句
	public int pstmtUpdate(String sql, String[] param) throws SQLException {
		// 本地測試，寫sql
		log(sql);
		log(toStrings(param));
		int RsCount = -1;
		try {
			if (conn == null) {
				conn = this.getConn();
			}
			pst = conn.prepareStatement(sql);
			pstmtList.addElement(pst);
			for (int i = 0; i < param.length; i++) {
				pst.setString(i + 1, param[i]);
			}
			RsCount = pst.executeUpdate();
		} catch (SQLException se) {
			this.sqlErrLog("sqlError", param, sql + se);
			se.printStackTrace();
			throw se;
		}
		return RsCount;
	}

	public int pstmtUpdateT(String sql, String param) throws SQLException {
		String[] params = param.split(",");
		// this.sqlErrLog("normalSql",param,sql);
		return this.pstmtUpdateT(sql, params);
	}

	public int pstmtUpdateT(String sql, String[] param) throws SQLException {
		// 本地測試，寫sql
		log(sql);
		log(toStrings(param));
		int RsCount = -1;
		try {
			if (conn == null) {
				conn = this.getConn();
			}
			pst = conn.prepareStatement(sql);
			pstmtList.addElement(pst);
			for (int i = 0; i < param.length; i++) {
				pst.setString(i + 1, param[i]);
			}
			RsCount = pst.executeUpdate();
		} catch (SQLException se) {
			this.sqlErrLog("sqlError", param, sql + se);
			se.printStackTrace();
			throw se;
		}
		return RsCount;
	}

	public ResultSet pstmtSelect(String sql, String param) throws SQLException {
		String[] params={};
		if(param!=null&&!param.equals("")){
			params = param.split(",");
		}
		return this.pstmtSelect(sql, params);
	}

	// 執行有IN型參數的Select語句
	public ResultSet pstmtSelect(String sql, String[] param) {
		// 本地測試，寫sql
		log(sql);
		log(toStrings(param));
		try {
			rs = null;
			if (conn == null) {
				conn = this.getConn();
			}
			pst = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			pstmtList.addElement(pst);
			for (int i = 0; i < param.length; i++) {
				pst.setString(i + 1, param[i]);
			}
			rs = pst.executeQuery();
			if (rs != null) {
				rsmt = rs.getMetaData();
			}
		} catch (Exception se) {
			this.sqlErrLog("sqlError", param, sql + se);
			se.printStackTrace();
		}
		return rs;
	}

	public int cstmtUpdate(String sql, String param) throws SQLException {
		String[] params = param.split(",");
		// this.sqlErrLog("normalSql",param,sql);
		return this.cstmtUpdate(sql, params);
	}

	// 返回受影響的記錄數
	public int cstmtUpdate(String sql, String[] param) throws SQLException {
		// 本地測試，寫sql
		log(sql);
		log(toStrings(param));
		int RsCount = -1;
		try {
			if (conn == null) {
				conn = this.getConn();
			}
			cst = conn.prepareCall(sql);
			cstmtList.addElement(cst);
			for (int i = 0; i < param.length; i++) {
				cst.setString(i + 1, param[i]);
			}
			RsCount = cst.executeUpdate();
		} catch (SQLException se) {
			this.sqlErrLog("sqlError", param, sql + se.toString());
		}
		return RsCount;
	}

	// 寫sql錯誤日志
	void sqlErrLog(String logtype, String subject, String msg) {
		// System.out.println("logtype=" + logtype);
		// System.out.println("subject=" + subject);
		// System.out.println("msg=" + msg);
		String sql1 = "INSERT INTO ckscore_syslog(logtype,subject,descriptions) VALUES(?,?,?)";
		String[] parms = new String[] { logtype, subject, msg };
		try {
			pst = this.getConn().prepareStatement(sql1);
			for (int i = 0; i < parms.length; i++) {
				pst.setString(i + 1, parms[i]);
			}
			pst.executeUpdate();
		} catch (Exception e) {
			this.writeLog4j(subject, msg);
			e.printStackTrace();
		}
	}

	//
	void sqlErrLog(String sql, String[] param, Object errMsg) {
		String params = "";
		for (int i = 0; i < param.length; i++) {
			params += param[i] + ",";
		}
		this.sqlErrLog(sql, params, errMsg.toString()); // 寫資料庫
	}

	// 打印執行的預編譯sql與其參數
	void writeLog4j(String sql, String[] params) {
		String param = "";
		for (int i = 0; i < params.length; i++) {
			param += params[i] + "  ";
		}
		writeLog4j(sql, param);
	}

	// 打印執行的預編譯sql與其參數
	void writeLog4j(String sql, String params) {
		log.error(new java.util.Date() + "sql:" + sql);
		log.error(new java.util.Date() + "param:" + params);
	}

	// 寫入log
	public void log(Object s) {
		// System.out.println(s.toString());
		this.WriteLog("/logNew.txt", s.toString()); // 本地日志文件
		// this.WriteLog("/www/human/sql_log.log", s.toString()); //服務器日志文件
		// this.WriteLog("/human/sql_log.log", s.toString());
	}

	void WriteLog(String fileName, String recLog) {
		FileWriter outFile;
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				file.createNewFile();
			}
			if (!file.exists()) {
				this.sqlErrLog("file no exist", "", "");
			}
			outFile = new FileWriter(file, true);
			BufferedWriter writeFile = new BufferedWriter(outFile);
			writeFile.newLine();
			writeFile.write(recLog);
			writeFile.close();
			outFile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String toStrings(String[] abs) {
		String result = "";
		for (int i = 0; i < abs.length; i++) {
			result += " " + abs[i];
		}
		return result;
	}

	// 關閉所有預編譯語句
	public void closePrst() {
		try {
			for (int i = 0; i < pstmtList.size(); i++) {
				PreparedStatement pst1 = (PreparedStatement) pstmtList
						.elementAt(i);
				pst1.close();
			}
		} catch (Exception e) {
			this.sqlErrLog("", "pstmtList關閉異常", "sqlerr:"
					+ e.getLocalizedMessage());
		}
		try {
			for (int i = 0; i < cstmtList.size(); i++) {
				CallableStatement cst1 = (CallableStatement) cstmtList
						.elementAt(i);
				cst1.close();
			}
		} catch (Exception e) {
			this.sqlErrLog("", "cstmtList關閉異常", "sqlerr:"
					+ e.getLocalizedMessage());
		}
		pstmtList.removeAllElements();
		cstmtList.removeAllElements();
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception e) {
		}

	}
}
