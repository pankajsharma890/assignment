package com.uxpsystems.assignment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {

}