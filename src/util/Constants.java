package util;

public class Constants {
    public static class Directions{
        public static final int LEFT = 0;
        public static final int RIGHT = 1;
        public static final int UP = 2;
        public static final int DOWN = 3;
    }
    public static class PlayerConstants{
        public static final int RUNNINGR = 1;
        public static final int JUMP = 2;
        public static final int DOUBLE_JUMP = 3;
        public static final int IDLER = 0;
        public static final int CLIMB = 4;
        public static final int PUNCH = 7;
        public static final int PUNCH_RUN = 9;
        public static final int HURT = 10;
        public static final int DIED = 11;
        public static final int RUNNINGL = 13;
        public static final int IDLEL = 12;

        public static int GetSpriteAmount(int action){
            switch (action){
                case IDLER -> {return 4;}
                case IDLEL -> {return 4;}
                case RUNNINGL -> {return 6;}
                case RUNNINGR -> {return 6;}
                case JUMP -> {return 4;}
                case DOUBLE_JUMP -> {return 6;}
                case CLIMB -> {return 6;}
                case PUNCH -> {return 8;}
                case PUNCH_RUN -> {return 6;}
                case HURT -> {return 2;}
                case DIED -> {return 6;}
                default -> {return 1;}
            }
        }
    }
}
