package jp.co.btc.hrms.dao;

import jp.co.btc.hrms.domain.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member, Long> {
  public Member getUserById(Long id);

  public Member findByUsername(String username);
}
