package by.epam.mentoring.model.enums;

public enum Role {
    ADMIN("admin"), USER("user"), UNKNOWN("unknown");

    private String dBRole;

    Role(String role) {
        dBRole = role;
    }

    public String getdBRole() {
        return dBRole;
    }

    public void setdBRole(String dBRole) {
        this.dBRole = dBRole;
    }

    public static Role getRolefromDB(String role) {
        switch (role) {
            case "admin":
                return ADMIN;
            case "user":
                return USER;
            default:
                return null;
        }
    }
}
