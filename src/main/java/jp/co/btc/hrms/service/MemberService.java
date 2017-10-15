
package jp.co.btc.hrms.service;

import java.util.List;

import javax.transaction.Transactional;

import jp.co.btc.hrms.domain.Member;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface MemberService {
  @Transactional
  public Member getById(Long id);

  @Transactional
  public void saveList(List<Member> membersList);

  @Transactional
  public Page<Member> findList(Pageable pageable);

  @Transactional
  public void save(Member member);

  @Transactional
  public Long login(Member member);

  @Transactional
  public void delete(Long id);

  @Transactional
  public Member update(Member member);

  @Transactional
  public Member isSign(String membername);
}
