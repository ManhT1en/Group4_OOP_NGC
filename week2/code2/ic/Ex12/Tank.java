package week2.code2.ic.Ex12;

public class Tank {
    private boolean isEmpty; // ktra tank rong hay day

    public Tank() {
        this.isEmpty = true; 
    }
    // fill tank
    public void fill() {
        isEmpty = false;
        System.out.println("Tank is now filled.");
    }
    // clear tank
    public void empty() {
        isEmpty = true;
        System.out.println("Tank is now empty.");
    }
    @Override
    protected void finalize() throws Throwable {
        if (!isEmpty) {
            System.out.println("Error: Tank is not empty during cleanup!");
        } else {
            System.out.println("Tank is empty during cleanup.");
        }
        super.finalize();
    }

    public static void main(String[] args) {
        // tank rong
        Tank tank1 = new Tank();
        tank1.fill(); 
        tank1.empty();
        tank1 = null;  
        System.gc();   

        // tank khong rong
        Tank tank2 = new Tank();
        tank2.fill();  
        tank2 = null;  
        System.gc(); 
        System.runFinalization();
    }
}
