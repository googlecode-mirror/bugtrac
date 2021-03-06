/*
  	BugTrac Open Source Bugtracking Software
    
    Copyright (C) 2012  Maximilian H.

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
    
    Download and more information: code.google.com/p/bugtrac
 
 */

package com.bugtrac.core;

import com.bugtrac.core.database.MySQL;

public class DatabaseAccess {
	MySQL mysql = null;
	
	public DatabaseAccess(DatabaseType type, DatabaseCredentials auth)
	{
		if (type == DatabaseType.MySQL)
		{
			mysql = new MySQL(auth.getHost(), auth.getDatabase(), auth.getUsername(), auth.getPassword());
			mysql.connect();
		}
	}
	
	public Boolean executeSQL(String sql)
	{
		if (mysql != null)
		{
			return mysql.executeSQL(sql);
		}
		
		return false;
	}
	
	public String[] getValue(String sql, int numRows)
	{
		if (mysql != null)
		{
			return mysql.getValue(sql, numRows);
		}
		
		return new String[] { "error" };
	}

}
