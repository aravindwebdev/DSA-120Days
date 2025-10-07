class Singleton{
    private static instance = null;
    private int value = 0;
    private Singleton(int value){
        this.value = value;
    }

    public static Singleton getInstance(){
        if(instance == null){
         synchronized(Singleton.class){
            if(instance == null){
                instance = new Singleton();
            }
            return instance;
         }
        }
    }
}