package jp.co.sample.hrms.repository;

import java.io.Serializable;

import org.springframework.util.Assert;

import lombok.Data;

@Data
public class MemberSearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String name;

	public MemberSearchCriteria() {
	}

	public MemberSearchCriteria(String name) {
		Assert.notNull(name, "Name must not be null");
		this.name = name;
	}

	public MemberSearchCriteria(long id) {
		Assert.notNull(id, "Id must not be null");
		this.id = id;
	}
}
