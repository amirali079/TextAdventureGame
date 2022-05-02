package game.control;

public class MyExeption extends Exception {
    @Override
    public void printStackTrace() {
        System.out.println("YOU LOSE!!!");
    }
}
