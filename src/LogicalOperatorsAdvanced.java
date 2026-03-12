public class LogicalOperatorsAdvanced {

    static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    static boolean isValidAge(int age)           { return age >= 0 && age <= 150; }
    static boolean isWeekend(String day)         { return day.equalsIgnoreCase("Saturday") || day.equalsIgnoreCase("Sunday"); }
    static boolean isValidEmail(String email)    { return email.contains("@") && email.contains(".") && email.length() > 5; }
    static boolean isInRange(int val, int lo, int hi) { return val >= lo && val <= hi; }

    static String accessLevel(boolean isAdmin, boolean isLoggedIn, boolean isBanned) {
        if (isBanned)                    return "BANNED";
        if (!isLoggedIn)                 return "GUEST";
        if (isLoggedIn && isAdmin)       return "ADMIN";
        return "USER";
    }

    public static void main(String[] args) {
        System.out.println("=== Leap Year Checker ===");
        int[] years = {2000, 1900, 2024, 2023, 2100, 2400};
        for (int y : years)
            System.out.printf("%d: %s%n", y, isLeapYear(y) ? "LEAP YEAR" : "not leap year");

        System.out.println("\n=== Email Validation ===");
        String[] emails = {"user@example.com", "invalid", "test@", "@no.com", "ok@mail.org"};
        for (String e : emails)
            System.out.printf("%-20s → %s%n", e, isValidEmail(e) ? "valid" : "invalid");

        System.out.println("\n=== Access Control System ===");
        Object[][] users = {
            {"Alice",  true,  true,  false},
            {"Bob",    false, true,  false},
            {"Charlie",false, false, false},
            {"Dave",   false, true,  true}
        };
        for (Object[] u : users)
            System.out.printf("%-10s → %s%n", u[0],
                accessLevel((Boolean)u[1], (Boolean)u[2], (Boolean)u[3]));

        System.out.println("\n=== Weekend Checker ===");
        String[] days = {"Monday", "Saturday", "Sunday", "Wednesday", "Friday"};
        for (String d : days)
            System.out.printf("%-12s → %s%n", d, isWeekend(d) ? "Weekend!" : "Weekday");
    }
}
