package jp.co.btc.hrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import jp.co.btc.hrms.dao.MemberDao;
import jp.co.btc.hrms.domain.Member;
import jp.co.btc.hrms.service.MemberService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
  @Autowired
  private MemberDao memberDao;

  @Override
  public Member getById(Long id) {
    return memberDao.findOne(id);
  }

  @Override
  public void saveList(List<Member> membersList) {
    @SuppressWarnings("unchecked")
    Iterable<Member> iterable = (Iterable<Member>) ((ArrayList<Member>) membersList).iterator();
    memberDao.save(iterable);
  }

  @Override
  public Page<Member> findList(Pageable pageable) {
    return memberDao.findAll(pageable);

  }

  @Override
  public void save(Member member) {
    memberDao.save(member);

  }

  @Override
  public void delete(Long id) {
    memberDao.delete(id);
  }

  @Override
  public Member update(Member member) {
    return memberDao.save(member);
  }

  @Override
  public Long login(Member member) {
    Member memberResult = memberDao.findByUsername(member.getUsername());
    if (memberResult != null && memberResult.getPassword().equals(member.getPassword())) {
      return memberResult.getId();
    } else {
      return 0L;
    }
  }

  @Override
  public Member isSign(String membername) {
    return memberDao.findByUsername(membername);
  }

}
