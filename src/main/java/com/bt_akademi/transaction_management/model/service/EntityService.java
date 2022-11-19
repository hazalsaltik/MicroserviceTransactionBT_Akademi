package com.bt_akademi.transaction_management.model.service;

import java.util.List;

public interface EntityService<E, I>
{
    List<E> getAll();

    // idyeGoreBul
    E findByID(I id);

    E save(E entity);

    void deleteById(I id);
}

