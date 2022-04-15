package com.wbw.pattern.creative.builder;

/**
 * @author wbw
 * @date 2022-4-5 22:51
 */
public class User {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "User(id="
                + this.getId() + ", name=" + this.getName() + ")";
    }

    User(Long var1, String var2) {
        this.id = var1;
        this.name = var2;
    }

    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    private User() {
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public static class UserBuilder {
        private Long id;
        private String name;

        UserBuilder() {
        }

        public User.UserBuilder id(Long var1) {
            this.id = var1;
            return this;
        }

        public User.UserBuilder name(String var1) {
            this.name = var1;
            return this;
        }

        public User build() {
            return new User(this.id, this.name);
        }
    }
}
