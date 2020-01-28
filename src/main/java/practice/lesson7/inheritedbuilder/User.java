package practice.lesson7.inheritedbuilder;

class User {
    private String email;
    private String password;

    protected User(UserBuilder userBuilder) {
        this.email = userBuilder.email;
        this.password = userBuilder.password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static class UserBuilder<SELF extends UserBuilder<SELF>> {
        private String email;
        private String password;

        public User build() {
            return new User(self());
        }

        public SELF withEmail(String email) {
            this.email = email;
            return self();
        }

        public SELF withPassword(String password) {
            this.password = password;
            return self();
        }

        @SuppressWarnings("unchecked")
        protected SELF self() {
            return (SELF) this;
        }
    }
}
