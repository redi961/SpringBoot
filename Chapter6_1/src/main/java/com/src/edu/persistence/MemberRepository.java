package com.src.edu.persistence;

import org.springframework.data.repository.CrudRepository;

import com.src.edu.domain.Member;

public interface MemberRepository extends CrudRepository<Member, String> {

}
