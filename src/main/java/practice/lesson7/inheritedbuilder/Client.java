package practice.lesson7.inheritedbuilder;

//Could be class User as abstract?

class Client extends User {
    private int code;

    public Client(ClientBuilder builder) {
        super(builder);
        this.code = builder.code;
    }

    static ClientBuilder clientBuilder() {
        return new ClientBuilder();
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "Client{" +
                "code=" + code +
                '}';
    }

    public static class ClientBuilder extends UserBuilder<ClientBuilder> {
        private int code;

        public Client build(){
            return new Client(this);
        }

        public ClientBuilder withCode(int code) {
            this.code = code;
            return this;
        }

        @Override
        protected ClientBuilder self() {
            return this;
        }
    }
}
