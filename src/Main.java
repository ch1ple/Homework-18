public class Main {
    public static void main(String[] args) {
        try {
            if (CheckService.check("Revolver", "Dima10102002", "Dima10102002")) {
                System.out.println("Вход выполнен");
            }
        } catch (WrongLoginException e) {
            System.err.println("WrongLoginException");
        } catch (WrongPasswordException e) {
            System.err.println("WrongPasswordException");
        }
    }
}