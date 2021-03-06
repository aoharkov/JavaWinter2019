package com.bank.dao;

public class AccountDaoImplTest {
    /*private static User[] users;
    private static Account[] accountsSizeOf4;
    private static Account[] accountsSizeOf3;
    private AccountDao repository;

    @BeforeClass
    public static void initAccounts() {
        initUsers();
        initAccountsSizeOf4();
        initAccountsSizeOf3();
    }

    @Before
    public void initRepository() {
        repository = new AccountDaoImpl();
        repository.save(accountsSizeOf3[0]);
        repository.save(accountsSizeOf3[1]);
        repository.save(accountsSizeOf3[2]);
    }

    @Test
    public void findAllShouldReturnListOfSize3() {
        assertEquals(3, repository.findAll().size());
    }

    @Test
    public void findAllShouldReturnAccounts() {
        assertArrayEquals(accountsSizeOf3, repository.findAll().toArray());
    }

    @Test
    public void findAllShouldReturnWithSizeEqualsZeroIfEmpty() {
        assertEquals(0, new AccountDaoImpl().findAll().size());
    }

    @Test
    public void saveShouldReturnAccountsSizeOf4() {
        repository.save(accountsSizeOf4[3]);
        assertArrayEquals(accountsSizeOf4, repository.findAll().toArray());
    }

    @Test
    public void findByIdShouldReturnAccount() {
        assertEquals(Optional.of(accountsSizeOf3[0]), repository.findById(1));
    }

    @Test
    public void findByIdShouldReturnOptionalEmptyIfEmpty() {
        assertEquals(Optional.empty(), new AccountDaoImpl().findById(1));
    }

    @Test
    public void updateShouldUpdateAccountWithIdEquals1() {
        Account updated = Account.builder()
                .withId(1)
                .withMoney(1100)
                .withUser(users[0])
                .build();
        repository.update(updated);
        assertEquals(Optional.of(updated), repository.findById(1));

    }

    @Test
    public void deleteById() {
        repository.save(accountsSizeOf4[3]);
        repository.deleteById(4);
        assertArrayEquals(accountsSizeOf3, repository.findAll().toArray());
    }

    private static void initUsers() {
        users = new User[2];
        users[0] = User.builder()
                .withId(1)
                .withEmail("email1")
                .withPassword("1111")
                .withAccounts(null)
                .build();
        users[1] = User.builder()
                .withId(2)
                .withEmail("email2")
                .withPassword("2222")
                .withAccounts(null)
                .build();
    }

    private static void initAccountsSizeOf4() {
        accountsSizeOf4 = new Account[4];
        accountsSizeOf4[0] = Account.builder()
                .withId(1)
                .withMoney(100)
                .withUser(users[0])
                .build();
        accountsSizeOf4[1] = Account.builder()
                .withId(2)
                .withMoney(1000)
                .withUser(users[0])
                .build();
        accountsSizeOf4[2] = Account.builder()
                .withId(3)
                .withMoney(200)
                .withUser(users[1])
                .build();
        accountsSizeOf4[3] = Account.builder()
                .withId(4)
                .withMoney(2000)
                .withUser(users[1])
                .build();
    }

    private static void initAccountsSizeOf3() {
        accountsSizeOf3 = new Account[]{accountsSizeOf4[0], accountsSizeOf4[1], accountsSizeOf4[2]};
    }*/
}