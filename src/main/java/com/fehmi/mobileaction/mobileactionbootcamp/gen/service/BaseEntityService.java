package com.fehmi.mobileaction.mobileactionbootcamp.gen.service;

import com.fehmi.mobileaction.mobileactionbootcamp.acc.dto.AccAccountDto;
import com.fehmi.mobileaction.mobileactionbootcamp.gen.entity.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E, Long>> {

    private static final Integer  DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;

    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }
    public List<E> findAll(Pageable pageable){

        Page<E> ePage = dao.findAll(pageable);

        return ePage.toList();
    }

    public List<E> findAll(Optional<Integer> pageOptional, Optional<Integer> sizeOptional){

        PageRequest pageRequest = getPageRequest(pageOptional, sizeOptional);

        return findAll(pageRequest);
    }

    private PageRequest getPageRequest(Optional<Integer> pageOptional, Optional<Integer> sizeOptional){
        Integer page = getPage(pageOptional);


        Integer size = getSize(sizeOptional);
        PageRequest pageRequest = PageRequest.of(page, size);

        return pageRequest;
    }

    protected Integer getSize(Optional<Integer> sizeOptional) {
        Integer size = DEFAULT_SIZE;
        if(sizeOptional.isPresent()){
            size = sizeOptional.get();
        }
        return size;
    }

    protected Integer getPage(Optional<Integer> pageOptional) {
        Integer page = DEFAULT_PAGE;
        if(pageOptional.isPresent()){
            page = pageOptional.get();
        }
        return page;
    }

    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E save(E e){
        return dao.save(e);
    }

    public void delete(E e){
        dao.delete(e);
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }
}
