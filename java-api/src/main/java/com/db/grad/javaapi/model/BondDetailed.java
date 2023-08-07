package com.db.grad.javaapi.model;

import java.util.List;

public class BondDetailed extends Security {
    private List<String> client_name;

    public BondDetailed(Security security, List<String> client_name) {
        super.setId(security.getId());
        super.setIsin(security.getIsin());
        super.setCusip(security.getCusip());
        super.setIssuer_name(security.getIssuer_name());
        super.setMaturity_date(security.getMaturity_date());
        super.setCoupon(security.getCoupon());
        super.setType(security.getType());
        super.setFace_value(security.getFace_value());
        super.setCurrency(security.getCurrency());
        super.setStatus(security.getStatus());
        this.client_name = client_name;
    }

    public List<String> getClient_name() {
        return client_name;
    }

    public void setClient_name(List<String> client_name) {
        this.client_name = client_name;
    }
}
