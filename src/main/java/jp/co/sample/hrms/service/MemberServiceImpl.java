/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.co.sample.hrms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import jp.co.sample.hrms.domain.Member;
import jp.co.sample.hrms.mapper.MemberMapper;

@Service("memberService")
@Transactional
class MemberServiceImpl implements MemberService {

	@Autowired
    MemberMapper memberMapper;

	@Override
	public Member getMember(long id, String name) {
		Assert.notNull(name, "Name must not be null");
		return this.memberMapper.findByIdOrName(id, name);
	}
    public Member getUserInfo(String userName){
        return memberMapper.findByNameAllIgnoringCase(userName);
    }

    public List<Member> getAllUserInfo(){
        return memberMapper.findAll();
    }
}
