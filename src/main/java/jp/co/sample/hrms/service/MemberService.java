package jp.co.sample.hrms.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import jp.co.sample.hrms.domain.Member;
import jp.co.sample.hrms.repository.MemberSearchCriteria;

public interface MemberService {

	Member getMember(long id, String name);
	Page<Member> findMembers(MemberSearchCriteria criteria, Pageable pageable);

}
