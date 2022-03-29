package com.example.demo.service.base;

import com.example.demo.repository.base.BaseRepository;
import com.example.demo.util.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<T, ID extends Serializable, R extends BaseRepository<T, ID>> implements BaseService<T, ID> {
    private R repository;

    protected R getRepository() {
        return this.repository;
    }

    @Autowired
    public void setRepository(R repository) {
        this.repository = repository;
    }

    @Transactional
    public T save(T t) {
        return this.getRepository().saveAndFlush(t);
    }

    @Transactional
    public T edit(T t) {
        return this.getRepository().saveAndFlush(t);
    }

    @Transactional
    public void delete(ID id) {
        this.getRepository().deleteById(id);
    }

    @Transactional
    public void delete(T t) {
        this.getRepository().delete(t);
    }

    @Transactional
    public Optional<T> find(ID id) {
        return this.getRepository().findById(id);
    }

    @Transactional
    public List<T> getAll() {
        return this.getRepository().findAll();
    }

    @Transactional
    public T findOrThrow(ID id) {
        return this.getRepository().findById(id).orElseThrow(() -> new EntityNotFoundException(this.getClass(), id));
    }
}
