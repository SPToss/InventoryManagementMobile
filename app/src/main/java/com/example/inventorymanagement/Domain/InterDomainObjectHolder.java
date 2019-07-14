package com.example.inventorymanagement.Domain;

public  class InterDomainObjectHolder {

    private static InterDomainObjectHolder _interDomainObjectHolder = null;

    private InterDomainObjectHolder() {

    }

    public static InterDomainObjectHolder GetInstance() {
        if (_interDomainObjectHolder == null) {
            _interDomainObjectHolder = new InterDomainObjectHolder();
        }
        return _interDomainObjectHolder;
    }
}