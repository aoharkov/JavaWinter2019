package com.bank.dao;

import com.bank.domain.User;
import com.bank.dao.impl.UserDaoImpl;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserDaoImplTest {
    /*private static User[] usersOfSize4;
    private static User[] usersOfSize3;
    private UserDao repository;

    @BeforeClass
    public static void initUsers() {
        initUsersSizeOf4();
        initUsersSizeOf3();
    }

    @Before
    public void initRepository() {
        repository = new UserDaoImpl();
        repository.save(usersOfSize4[0]);
        repository.save(usersOfSize4[1]);
        repository.save(usersOfSize4[2]);
    }

    @Test
    public void findAllShouldReturnListOfSize3() {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    public void findByEmailShouldFindUser2() {
        assertEquals(Optional.of(usersOfSize4[1]), repository.findByEmail("email2"));
    }

    @Test
    public void findByEmailShouldFindOptionalEmpty() {
        assertEquals(Optional.empty(), repository.findByEmail("wrong email"));
    }

    @Test
    public void saveShouldReturnUsersOfSize4() {
        repository.save(usersOfSize4[3]);
        assertArrayEquals(usersOfSize4, repository.findAll().toArray());
    }

    @Test
    public void findByIdShouldReturnUser1() {
        assertEquals(Optional.of(usersOfSize3[0]), repository.findById(1));
    }

    @Test
    public void findByIdShouldReturnOptionalEmpty() {
        assertEquals(Optional.empty(), repository.findById(10));
    }

    @Test
    public void findByIdShouldReturnOptionalEmptyIfEmpty() {
        assertEquals(Optional.empty(), new UserDaoImpl().findById(1));
    }

    @Test
    public void updateShouldUpdateUser1() {
        User updated = User.builder()
                .withId(1)
                .withEmail("new.email1")
                .withPassword("1111")
                .withAccounts(null)
                .build();
        repository.update(updated);
        assertEquals(Optional.of(updated), repository.findById(1));
    }

    @Test
    public void deleteById() {
        repository.save(usersOfSize4[3]);
        repository.deleteById(4);
        assertArrayEquals(usersOfSize3, repository.findAll().toArray());
    }

    private static void initUsersSizeOf4() {
        usersOfSize4 = new User[4];
        usersOfSize4[0] = User.builder()
                .withId(1)
                .withEmail("email1")
                .withPassword("1111")
                .withAccounts(null)
                .build();
        usersOfSize4[1] = User.builder()
                .withId(2)
                .withEmail("email2")
                .withPassword("2222")
                .withAccounts(null)
                .build();
        usersOfSize4[2] = User.builder()
                .withId(3)
                .withEmail("email3")
                .withPassword("3333")
                .withAccounts(null)
                .build();
        usersOfSize4[3] = User.builder()
                .withId(4)
                .withEmail("email4")
                .withPassword("4444")
                .withAccounts(null)
                .build();
    }

    private static void initUsersSizeOf3() {
        usersOfSize3 = new User[]{usersOfSize4[0], usersOfSize4[1], usersOfSize4[2]};
    }*/
}