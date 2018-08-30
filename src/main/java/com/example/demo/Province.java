package com.example.demo;

public class Province extends StateCouncil implements CentralPartyCommittee {
    @Override
    public void partyLeader(){
        System.out.println("我们各省人民一定坚持党的领导！");
    }

    @Override
    void safetyInProduction(){
        System.out.println("我们各省人民一定按照国务院的指示进行安全生产！");
    }
}
