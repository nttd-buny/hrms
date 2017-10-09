package jp.co.sample.hrms.service;

import jp.co.sample.hrms.domain.Member;

public interface MemberService {

	Member getMember(long id, String name);
}
