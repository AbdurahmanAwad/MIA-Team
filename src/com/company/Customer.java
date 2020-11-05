package com.company;

public class Customer {
    private String name;
    private boolean isMember = false;
    private String memberType = "";

    public Customer(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public boolean isMember() {return isMember; }

    private void setMember(boolean member) { isMember = member; }

    public String getMemberType() { return memberType; }

    public void setMemberType(String memberType) {
        this.memberType = memberType.trim().toLowerCase();
        System.out.println(this.memberType);
        if (memberType.equalsIgnoreCase("premium")
                || memberType.equalsIgnoreCase("gold")
                || memberType.equalsIgnoreCase("silver"))
            isMember = true;
    }


}
