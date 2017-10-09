package jp.co.sample.hrms.repository;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

import jp.co.sample.hrms.domain.Member;

@Mapper
public interface MemberRepository extends Repository<Member, Long> {

	Page<Member> findAll(Pageable pageable);

	Page<Member> findByNameAllIgnoringCase(String name);

	Member findById(long id);

	Member findByIdOrName(long id, String name);
}
