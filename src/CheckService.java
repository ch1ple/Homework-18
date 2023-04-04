public class CheckService {
    private static void checkFirst(String login) throws WrongLoginException {
        for (int i = 0; i < login.length(); i++) {
            char c = Character.toLowerCase(login.charAt(i));
            if ((c >= 'a' && c <= 'z') || c == '_' || c >= '0' && c <= '9') {
                continue;
            }
            throw new WrongLoginException();
        }
    }
    public static boolean check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
            checkFirst(login);
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
            checkFirst(password);
            if (password.length() >= 20) {
                throw new WrongPasswordException();
            }
            return password.equals(confirmPassword);
    }

    private static char[] allowedChars = new char[]{
            'a', 'b', 'c', '_'
    };
    private static void checkSecond(String login) throws WrongLoginException {
        for (int i = 0; i < login.length(); i++) {
            char c = Character.toLowerCase(login.charAt(i));
            boolean matched = false;
            for (char allowedChar : allowedChars) {
                if (c == allowedChar) {
                    matched = true;
                    break;
                }
            }
            if (!matched) {
                throw new WrongLoginException();
            }
        }
    }

    private static void checkThird(String login) throws WrongLoginException {
        if (!login.matches("^[a-zA-Z0-9]+$")) {
            throw new WrongLoginException();
        }
    }
}
