package ss14_exception_handling_debug.exercise.ex01_su_dung_lop_illegaltriangleexception;

public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) throws IllegalTriangleException {
        if (sideA < 0 || sideB < 0 || sideC < 0) {
            throw new IllegalTriangleException("Canh tam giac khong duoc nho hon 0");
        } else if ((sideA + sideB) <= sideC || (sideA + sideC) <= sideB || (sideB + sideC) <= sideA) {
            throw new IllegalTriangleException("Tong hai canh khong lon hon mot canh");
        } else {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
        }

    }

    public int getSideA() {
        return sideA;
    }

    public void setSideA(int sideA) {
        this.sideA = sideA;
    }

    public int getSideB() {
        return sideB;
    }

    public void setSideB(int sideB) {
        this.sideB = sideB;
    }

    public int getSideC() {
        return sideC;
    }

    public void setSideC(int sideC) {
        this.sideC = sideC;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "sideA=" + sideA +
                ", sideB=" + sideB +
                ", sideC=" + sideC +
                '}';
    }
}
