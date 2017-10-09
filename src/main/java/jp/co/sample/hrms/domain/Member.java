
package jp.co.sample.hrms.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	private String birthday;

	private String sex;

	private String addr1;

	private String addr2;

	private String addr3;

	private String mobile_div_1;

	private String mobile1;

	private String mobile_div_2;

	private String mobile2;

	private String mail1;

	private String mail2;

	private String webchat;

	private String fackbook;

	private String qq;

	private String linkln;

	private String line;

	private String other1;

	private String other2;
}
