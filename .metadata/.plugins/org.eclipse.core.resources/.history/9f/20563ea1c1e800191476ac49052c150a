package com.hanrabong.web.enums;

public enum DBUrl {
	ORACLE_URL,
	MARIA_URL,
	H2_URL;
	
	@Override
	public String toString() {
		String url = "";
		switch (this) {
		case ORACLE_URL:
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			break;
		case MARIA_URL:
			url = "jdbc:mariadb:localhost:3306/데이터베이스명:xe";
			break;
		case H2_URL:
			url = "jdbc:h2:~/apps/h2db/crm;AUTO_SERVER=TRUE";
			break;
		default:
			break;
		}
		return url;
	}
}