package com.sysfactelect.admin.controller.mapper;

public interface IMapper <I, O>{
    public O map(I in);
    public O mapExist(I in, O inExist);
}
