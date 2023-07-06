package com.example.jdbc.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
public class Member {

    private String memberId;
    private int money;

    public Member() {

    }

    public Member(String memberId, int money) {
        this.memberId = memberId;
        this.money = money;
    }


    /**
     *
     * @Data 가 해결해준다
     *
     *  @Override
     *     public boolean equals(Object obj) {
     *         if(obj instanceof Member) {
     *             Member member = (Member) obj;
     *             return this.memberId.equals(member.memberId) && this.money == member.getMoney();
     *         }
     *         return false;
     *     }
     *
     *     @Override
     *     public int hashCode() {
     *         return Objects.hash(memberId, money);
     *     }
     */




}
