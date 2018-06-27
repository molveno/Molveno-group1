package com.hotelmolveno.hotel;

public class RoomTypeApp {

    public class EnumTest {
        RoomType roomType;

        public EnumTest(RoomType roomType) {
            this.roomType = roomType;
        }

        public void tellItLikeItIs() {
            switch (roomType) {
                case BUDGET:
                    System.out.println("This is a budget room");
                    break;

                case STANDARD:
                    System.out.println("This is a standard room");
                    break;

                case LUXURY:
                    System.out.println("This is a luxury room");
                    break;

                default:
                    System.out.println("This is not a valid room type");
                    break;
            }
        }
    }
}
