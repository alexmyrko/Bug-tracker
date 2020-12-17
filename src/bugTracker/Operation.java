package bugTracker;

public enum Operation {
    LOGIN, REGISTER, CREATE, EDIT, VIEW, EXIT;

    // get logging / register operation (LOGIN , REGISTER) or exit
    public static Operation getLoginOperationByOrdinal(int n){
        switch (n){
            case 1 :
                return LOGIN;
            case 2:
                return REGISTER;
            case 3:
                return EXIT;
            default:
                throw new IllegalArgumentException();
        }
    }

    // get one of routine Operations (CREATE, EDIT, VIEW) or exit
    public static Operation getRoutineOperationByOrdinal(int n){
        // TODO

    }
}
