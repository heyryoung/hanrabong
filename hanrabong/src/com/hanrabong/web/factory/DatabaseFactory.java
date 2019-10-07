package com.hanrabong.web.factory;

import com.hanrabong.web.enums.DB;

public class DatabaseFactory {
	public static Database createDatabase(String vendor){
		Database db = null;
		switch (DB.valueOf(vendor.toUpperCase())) {
		case ORACLE: db = new Oracle(); 
			break;
		}
		return db;
	}

}