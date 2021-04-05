package sample;

public class SaveClass extends Thread{
    @Override
    public void run() {
        Main.users.Save();
        super.run();
    }
}
