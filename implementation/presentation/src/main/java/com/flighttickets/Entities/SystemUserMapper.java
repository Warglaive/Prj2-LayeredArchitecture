package com.flighttickets.Entities;

import nl.fontys.sebivenlo.dao.AbstractMapper;

import java.util.function.Function;

public class SystemUserMapper extends AbstractMapper<Integer, SystemUser> {
    /**
     * Create a mapper for entity and key type.
     */
    public SystemUserMapper() {
        super(Integer.class, SystemUser.class);
    }

    @Override
    public Object[] explode(SystemUser e) {
        return e.asParts();
    }

    @Override
    public Function<SystemUser, Integer> keyExtractor() {
        return SystemUser::getId;
    }

    @Override
    public String tableName() {
        return "systemUser";
    }
}
