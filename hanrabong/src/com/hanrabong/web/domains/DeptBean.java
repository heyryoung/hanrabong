package com.hanrabong.web.domains;

import java.io.Serializable;
import lombok.Data;


@Data
public class DeptBean implements Serializable{
	private static final long serialVersionUID= 1L;
	
	private String deptNo, dName, loc;
	
	
}
