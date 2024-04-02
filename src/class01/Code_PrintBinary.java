package class01;

public class Code_PrintBinary {

    public static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.printf((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int num = 3;
        print(num);
//       00000000000000000000000000000011   正数 补码 = 原码 = 反码
//        int num = -3;
//        print(num);
//        11111111111111111111111111111101     负数显示补码 补码 = 反码+1 反码等于原码除符号位的取反
    }

}
