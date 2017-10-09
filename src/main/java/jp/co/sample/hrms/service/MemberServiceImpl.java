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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import jp.co.sample.hrms.domain.Member;
import jp.co.sample.hrms.repository.MemberRepository;
import jp.co.sample.hrms.repository.MemberSearchCriteria;

@Component("memberService")
@Transactional
class MemberServiceImpl implements MemberService {

	@Autowired
    MemberRepository memberRepository;

	@Override
	public Page<Member> findMembers(MemberSearchCriteria criteria, Pageable pageable) {

		Assert.notNull(criteria, "Criteria must not be null");
		String name = criteria.getName();

		if (!StringUtils.hasLength(name)) {
			return memberRepository.findAll(null);
		}

		int splitPos = name.lastIndexOf(",");

		if (splitPos >= 0) {
			name = name.substring(0, splitPos);
		}

		return this.memberRepository
				.findByNameAllIgnoringCase(name.trim());
	}

	@Override
	public Member getMember(long id, String name) {
		Assert.notNull(name, "Name must not be null");
		return this.memberRepository.findByIdOrName(id, name);
	}

}
