package com.example.jdbc.service;


import com.example.jdbc.domain.Member;
import com.example.jdbc.repository.MemberRepositoryV1;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;

@RequiredArgsConstructor
public class MemberServiceV1 {

    private final MemberRepositoryV1 memberRepository;

    // fromId 의 회원을 조회해서 toId 의 회원에게 money 만큼의 돈을 계좌이체 하는 로직이다.
    public void accountTransfer(String fromId, String toId, int money) throws SQLException {
        Member fromMember = memberRepository.findById(fromId);
        Member toMember = memberRepository.findById(toId);

        memberRepository.update(fromId, fromMember.getMoney() - money);
        validator(toMember);
        memberRepository.update(toId, toMember.getMoney() + money);

    }

    private void validator(Member toMember) {
        if(toMember.getMemberId().equals("ex")) {
            throw new IllegalStateException("미제출 예외 발생");
        }
    }
}
