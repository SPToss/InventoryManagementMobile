package com.example.inventorymanagement.DataAccess;

import com.example.inventorymanagement.DataAccess.Interface.IServiceDao;

public class ServiceDao extends DaoBase implements IServiceDao {

    @Override
    public boolean IsConnectionActive() {
        return true; // TODO Call actual DB.
    }
}
